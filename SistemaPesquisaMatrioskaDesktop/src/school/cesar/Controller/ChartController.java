package school.cesar.Controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;  


public class ChartController extends Application {  
	@Override
	public void start(Stage stage) {
		
		Scene scene = new Scene(new Group());

	    stage.setTitle("Europian Country Population");
	    stage.setWidth(1350);
	    stage.setHeight(500);
	    stage.setResizable(false);
	    
	 
	    // Pichart 1 - CURSO
	    ObservableList<PieChart.Data> pieChartData1 =
	            FXCollections.observableArrayList(
	            new PieChart.Data("Ciência da Computação", 88),
	            new PieChart.Data("Design", 101));
	            
	    
	    final PieChart pieChart1 = new PieChart(pieChartData1);
	    pieChart1.setTitle("Curso");
	    pieChart1.setLayoutX(-40);
	    pieChart1.setLayoutY(20);

	    
	    final Label caption = new Label("");
	    caption.setTextFill(Color.DARKORANGE);
	    caption.setStyle("-fx-font: 24 arial;");
	    Tooltip container = new Tooltip();
	    container.setGraphic(caption);

	    pieChart1.getData().forEach((data) ->
	    {
	        data.getNode().
	                addEventHandler(MouseEvent.MOUSE_PRESSED, e ->
	                {
	                    if (container.isShowing())
	                    {
	                        container.hide();
	                        
	                    } 
	                    caption.setText(String.valueOf(data.getPieValue()));
	                    container.show(stage, e.getScreenX(), e.getScreenY());
	                    
	                });        
	    });
	    
	    
	 // Pichart 2 - PERIODO
	    ObservableList<PieChart.Data> pieChartData2 =
	            FXCollections.observableArrayList(
	            new PieChart.Data("1º", 102),
	            new PieChart.Data("2º", 55),
	            new PieChart.Data("3º", 32));
	    
	   	    
	    final PieChart pieChart2 = new PieChart(pieChartData2);
	    pieChart2.setTitle("Período");
	    pieChart2.setLayoutX(350);
	    pieChart2.setLayoutY(20);
	    
//	    final Label caption = new Label("");
	    caption.setTextFill(Color.DARKORANGE);
	    caption.setStyle("-fx-font: 24 arial;");
//	    Tooltip container = new Tooltip();
	    container.setGraphic(caption);

	    for (final PieChart.Data data : pieChart2.getData())
	    {
	     data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
	             new EventHandler<MouseEvent>()
	                {
	                  @Override
	                  public void handle(MouseEvent e)
	                  {
	                    if (container.isShowing())
	                    {
	                        container.hide();
	                    }
	                    caption.setText(String.valueOf(data.getPieValue()));
	                    container.show(stage, e.getScreenX(), e.getScreenY());
	                }
	            });
	        }
	    
	    
	    CategoryAxis xAxis = new CategoryAxis();
	    xAxis.setLabel("Valores");
 
	    NumberAxis yAxis = new NumberAxis(0, 30, 1);
	    yAxis.setLabel("Quantidade de Pessoas");
 
	    // Create a BarChart
	    BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
 
	    // Series 1 - Data of 2014
	    XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();
	    dataSeries.setName("2014");
 
	    dataSeries.getData().add(new XYChart.Data<String, Number>("1", 20));
	    dataSeries.getData().add(new XYChart.Data<String, Number>("2", 4));
	    dataSeries.getData().add(new XYChart.Data<String, Number>("3", 2));
	    dataSeries.getData().add(new XYChart.Data<String, Number>("4", 4));
	    dataSeries.getData().add(new XYChart.Data<String, Number>("5", 2));
 
 
	    // Add Series to BarChart.
	    barChart.getData().add(dataSeries);
 
	    barChart.setTitle("Notas (1 - 5)");
	    stage.setTitle("Matrioska Desktop - Charts");

	    VBox vbox = new VBox(barChart);
	    vbox.setLayoutX(850);
	    vbox.setLayoutY(20);
       
	    
	    // Adicionando charts à scene
	    ((Group) scene.getRoot()).getChildren().add(pieChart1);
	    ((Group) scene.getRoot()).getChildren().add(pieChart2);
	    ((Group) scene.getRoot()).getChildren().add(vbox);
	    
	    
//	    
	    
	    stage.setScene(scene);
	    stage.show();
	}  
	
}  

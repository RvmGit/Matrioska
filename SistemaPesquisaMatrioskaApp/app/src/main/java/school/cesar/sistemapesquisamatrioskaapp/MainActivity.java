package school.cesar.sistemapesquisamatrioskaapp;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText valorCapturadoPergunta1;
    private Spinner valorCapturadoPergunta2;

    private final int ID_TEXTO_PARA_VOZ1 = 100;
    private Button valorCapturadoPergunta3;
    private AlertDialog alertDialogPerguta3;
    private TextView editTextPergunta3;
    private TextView txtValorTranscritoPergunta3;


    private RadioGroup valorCapturadoPergunta4;
    private RadioButton radioButton;

    private final int ID_TEXTO_PARA_VOZ2 = 200;
    private Button valorCapturadoPergunta5;
    private AlertDialog alertDialogPerguta5;
    private TextView editTextPergunta5;
    private TextView txtValorTranscritoPergunta5;

    private Button btnEnviarInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.teste_layout);
        setContentView(R.layout.activity_main);


        valorCapturadoPergunta1 = findViewById(R.id.valorCapturadoPergunta1);
        valorCapturadoPergunta2 = findViewById(R.id.valorCapturadoPergunta2);
        valorCapturadoPergunta3 = findViewById(R.id.valorCapturadoPergunta3);
        txtValorTranscritoPergunta3 = findViewById(R.id.txtValorTranscritoPergunta3);
        valorCapturadoPergunta4 = findViewById(R.id.valorCapturadoPergunta4);
        valorCapturadoPergunta5 = findViewById(R.id.valorCapturadoPergunta5);
        txtValorTranscritoPergunta5 = findViewById(R.id.txtValorTranscritoPergunta5);


        btnEnviarInfo = findViewById(R.id.btnEnviarInfo);



        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////
        /////////////////// CODIGO DO EDIT TEXT ////////////////////////////////////////////

//        btnEnviarInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String value = valorCapturadoPergunta1.getText().toString();
//                TextView txtPergunta1 = findViewById(R.id.txtPergunta1);
//                txtPergunta1.setText(value);
//            }
//        });

        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////




        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////
        /////////////////// CODIGO DO SPINNER /////////////////////////////////////////////////

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.estados_lista, android.R.layout.simple_spinner_item);
        valorCapturadoPergunta2.setAdapter(adapter);



//        btnEnviarInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {       // trocar por btnEnviarInfo, no final de tudo
//                String item = valorCapturadoPergunta2.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
//
//                TextView txt = findViewById(R.id.txtPergunta5);
//                txt.setText(item);   // Enviar valor capturado
//            }
//        });

        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////






        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////
        /////////////////// CODIGO SPEECH TO TEXT 1 /////////////////////////////////////////////////


        alertDialogPerguta3 = new AlertDialog.Builder(this).create();
        editTextPergunta3 = new EditText(this);
        alertDialogPerguta3.setTitle(" Editar reposta ");
        alertDialogPerguta3.setView(editTextPergunta3);

        alertDialogPerguta3.setButton(DialogInterface.BUTTON_POSITIVE,
                "SALVAR ALTERAÇÃO", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                txtValorTranscritoPergunta3.setText(editTextPergunta3.getText());
            }
        });


        txtValorTranscritoPergunta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextPergunta3.setText(txtValorTranscritoPergunta3.getText());
                alertDialogPerguta3.show();
            }
        });


        valorCapturadoPergunta3.setOnClickListener(new View.OnClickListener() {    // Capturando o click do usuario
            @Override
            public void onClick(View v) {

                Intent iVoz = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // Definindo a acao de reconhecimento de voz

                // Setando o idioma e a forma como irá falar
                iVoz.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                // Setando o idioma default do CELULAR
                iVoz.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                // Prompt que vai aparecer pro usuario (O microfone e o texto em cima), nesse caso o texto como segundo parametro
                iVoz.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale algo normalmente");

                iVoz.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 2000000000);

                // Startando a activity, colocando dentro de um try catch, porque pode ser que o celular nao tenha suporte
                try {
                    startActivityForResult(iVoz, ID_TEXTO_PARA_VOZ1);    // Passando a Intent e o ID da minha aplicação
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),
                            "Seu celular não suporta comando de voz...", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnEnviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = findViewById(R.id.txtPergunta1);
                txt.setText(txtValorTranscritoPergunta3.getText());
            }
        });



        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////


        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////
        /////////////////// CODIGO DO RADIO BUTTON ////////////////////////////////////////////

//        btnEnviarInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int radioValue = valorCapturadoPergunta4.getCheckedRadioButtonId();
//
//                radioButton = findViewById(radioValue);     // Valor para retornar
//
//            }
//        });

        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////


        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////
        /////////////////// CODIGO SPEECH TO TEXT 2 /////////////////////////////////////////////////


        alertDialogPerguta5 = new AlertDialog.Builder(this).create();
        editTextPergunta5 = new EditText(this);
        alertDialogPerguta5.setTitle(" Editar reposta ");
        alertDialogPerguta5.setView(editTextPergunta5);

        alertDialogPerguta5.setButton(DialogInterface.BUTTON_POSITIVE,
                "SALVAR ALTERAÇÃO", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        txtValorTranscritoPergunta5.setText(editTextPergunta5.getText());
                    }
                });


        txtValorTranscritoPergunta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextPergunta5.setText(txtValorTranscritoPergunta5.getText());
                alertDialogPerguta5.show();
            }
        });


        valorCapturadoPergunta5.setOnClickListener(new View.OnClickListener() {    // Capturando o click do usuario
            @Override
            public void onClick(View v) {

                Intent iVoz = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // Definindo a acao de reconhecimento de voz

                // Setando o idioma e a forma como irá falar
                iVoz.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                // Setando o idioma default do CELULAR
                iVoz.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                // Prompt que vai aparecer pro usuario (O microfone e o texto em cima), nesse caso o texto como segundo parametro
                iVoz.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale algo normalmente");

                iVoz.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 2000000000);

                // Startando a activity, colocando dentro de um try catch, porque pode ser que o celular nao tenha suporte
                try {
                    startActivityForResult(iVoz, ID_TEXTO_PARA_VOZ2);    // Passando a Intent e o ID da minha aplicação
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),
                            "Seu celular não suporta comando de voz...", Toast.LENGTH_SHORT).show();
                }

            }
        });

//        btnEnviarInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView txt = findViewById(R.id.txtPergunta1);
//                TextView tim = findViewById(R.id.txtPergunta4);
//                txt.setText(txtValorTranscritoPergunta3.getText());
//                tim.setText(txtValorTranscritoPergunta5.getText());
//
//            }
//        });



        ////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////


    }


    @Override
    protected void onActivityResult(int id, int resultCodeID, Intent dados) {
        super.onActivityResult(id, resultCodeID, dados);

        switch (id) {
            case ID_TEXTO_PARA_VOZ1:
                if (resultCodeID == RESULT_OK && dados != null) {
                    List<String> result = dados.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    String ditado = result.get(0);

                    Toast.makeText(getApplicationContext(), ditado, Toast.LENGTH_LONG).show();

                    txtValorTranscritoPergunta3.setText(ditado);

                }
                break;

            case ID_TEXTO_PARA_VOZ2:
                if (resultCodeID == RESULT_OK && dados != null) {
                    List<String> result = dados.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    String ditado = result.get(0);

                    Toast.makeText(getApplicationContext(), ditado, Toast.LENGTH_LONG).show();

                    txtValorTranscritoPergunta5.setText(ditado);

                }
                break;
        }

    }


}

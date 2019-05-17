import speech_recognition as sr
from wordcloud import WordCloud
import matplotlib.pyplot as plt
from PIL import Image
import numpy as np

r = sr.Recognizer()
audio_path = 'teste_audio.wav'
image_mask = np.array(Image.open('cloud.png'))

with sr.AudioFile(audio_path) as source:

    audio = r.record(source)
    print("Convertendo ...")

    try:
        text = r.recognize_google(audio, language = 'pt-BR')
        print(text)

    except Exception as e:
        print(e)


###########################################
# IMPLEMENTACAO DO WORCLOUD
###########################################

cloud = WordCloud(background_color="white", mask = image_mask).generate(text)

plt.imshow(cloud, interpolation="bilinear")
plt.axis('off')
plt.show()


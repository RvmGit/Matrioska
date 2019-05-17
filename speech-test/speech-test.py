import speech_recognition as sr

r = sr.Recognizer()
audio_path = 'teste_audio.wav'

with sr.AudioFile(audio_path) as source:

    audio = r.record(source)
    print("Convertendo ...")

    try:
        text = r.recognize_google(audio, language = 'pt-BR')
        print(text)

    except Exception as e:
        print(e)

import speech_recognition as sr

r = sr.Recognizer()
audioF = 'Work.wav'

with sr.AudioFile(audioF) as source:
    audio = r.record(source)
    print("Done!")
    try:
        text = r.recognize_google(audio, language = 'pt-BR')
        print(text)
    except Exception as e:
        print("Sorry could not recognize what you said")

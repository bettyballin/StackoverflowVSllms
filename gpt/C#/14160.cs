ServiceReference1.SpeechServiceClient client = new ServiceReference1.SpeechServiceClient();\nclient.GetSpeechCompleted += (s, e) =>\n{\n    if (e.Error == null)\n    {\n        var audioData = e.Result;\n        // Play the audio data in Silverlight\n    }\n};\nclient.GetSpeechAsync("Your text here");
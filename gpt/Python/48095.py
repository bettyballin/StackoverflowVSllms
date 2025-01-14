from pydub import AudioSegment\n\n   sound1 = AudioSegment.from_file("guitar.mp3")\n   sound2 = AudioSegment.from_file("vocals.mp3")\n\n   combined = sound1.overlay(sound2)\n\n   combined.export("output.mp3", format="mp3")
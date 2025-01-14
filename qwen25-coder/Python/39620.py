from pydub import AudioSegment\n\n   # Load an MP3 file\n   sound = AudioSegment.from_mp3("yourfile.mp3")\n\n   # Cut 10 seconds from the 3rd minute\n   edit_sound = sound[:180000] + sound[240000:]\n\n   # Export to a new file\n   edit_sound.export("newfile.mp3", format="mp3", bitrate="320k")
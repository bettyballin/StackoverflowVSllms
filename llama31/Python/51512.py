from pydub import AudioSegment\n\n# Load the MP3 file\naudio = AudioSegment.from_mp3("input.mp3")\n\n# Define the start and end times of the section to remove\nstart_time = 3 * 60 * 1000  # 3 minutes\nend_time = start_time + 10 * 1000  # 10 seconds later\n\n# Remove the section\naudio = audio[:start_time] + audio[end_time:]\n\n# Save the modified MP3 file\naudio.export("output.mp3", format="mp3")
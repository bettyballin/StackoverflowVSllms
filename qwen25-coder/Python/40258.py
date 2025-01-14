import os\n\ndef concatenate_mp3_files(input_files, output_file):\n    with open(output_file, 'wb') as outfile:\n        for file in input_files:\n            if os.path.isfile(file):  # Check if the file exists\n                with open(file, 'rb') as infile:\n                    outfile.write(infile.read())\n            else:\n                print(f"Warning: {file} not found. Skipping.")\n\n# Example usage\ninput_mp3s = ['song1.mp3', 'song2.mp3', ..., 'song40.mp3']  # List your files here\noutput_mp3 = 'combined_song.mp3'\nconcatenate_mp3_files(input_mp3s, output_mp3)
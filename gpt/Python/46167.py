import os\n\nfile_path = 'path/to/your/file.txt'\ntemp_file_path = file_path + '.tmp'\n\nwith open(file_path, 'r') as f, open(temp_file_path, 'w') as temp_f:\n    for line in f:\n        if 'foo' in line:\n            newline = line.replace('foo', 'bar')\n        else:\n            newline = line\n        temp_f.write(newline)\n\n# Replace the original file with the temporary file\nos.replace(temp_file_path, file_path)
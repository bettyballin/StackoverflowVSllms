import os\n\n# Define directory path without trailing slash\ndir_path = '/var/www/apps'\n\n# Append file name or subdirectory safely\nfile_path = os.path.join(dir_path, 'file.txt')\nsubdir_path = os.path.join(dir_path, 'subdir')
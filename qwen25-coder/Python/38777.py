import os\nimport time\n\n# Path to your file\nfile_path = '/path/to/your/file'\n\n# Desired new timestamp (e.g., January 1, 2023)\nnew_timestamp = time.mktime((2023, 1, 1, 0, 0, 0, 0, 0, 0))\n\n# Set the new access and modification times\nos.utime(file_path, (new_timestamp, new_timestamp))
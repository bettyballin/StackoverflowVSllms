import os\n\ndef truncate_log_file(file_path, max_size, lines_to_remove):\n    if os.path.getsize(file_path) > max_size:\n        with open(file_path, 'r') as file:\n            lines = file.readlines()\n        \n        with open(file_path, 'w') as file:\n            file.writelines(lines[lines_to_remove:])\n    \n# Example usage\nfile_path = 'path/to/logfile.log'\nmax_size = 10 * 1024 * 1024  # 10 MB\nlines_to_remove = 100\n\ntruncate_log_file(file_path, max_size, lines_to_remove)
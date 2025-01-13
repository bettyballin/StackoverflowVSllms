import os\nimport stat\n\ntimestamp_file = 'timestamp-file'\ntimestamp = os.stat(timestamp_file).st_ctime_ns\n\nfor file in os.listdir('.'):\n  file_stat = os.stat(file)\n  if file_stat.st_ctime_ns > timestamp:\n    print(file)
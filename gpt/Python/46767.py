import csv\n\n# Open the file and keep a reference to the file object\nfile_path = 'example.csv'\nfile_obj = open(file_path, mode='r', newline='')\n\n# Create a CSV reader object\ncsv_reader = csv.reader(file_obj)\n\n# Use the csv_reader to read data\nfor row in csv_reader:\n    print(row)\n\n# Now you can still access the file_obj\nprint(f"File object: {file_obj}")\n\n# Don't forget to close the file when done\nfile_obj.close()
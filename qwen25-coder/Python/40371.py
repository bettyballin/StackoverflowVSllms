import csv\n\n# Open the CSV file\nwith open('yourfile.csv', mode='r', newline='') as file:\n    # Create a CSV reader object\n    csv_reader = csv.reader(file)\n    \n    # Iterate over rows in the CSV file\n    for row in csv_reader:\n        print(row)\n    \n    # To return to the top of the file, use seek(0)\n    file.seek(0)\n    \n    # Create another CSV reader if needed\n    csv_reader_from_top = csv.reader(file)\n    \n    # Iterate over rows again from the beginning\n    for row in csv_reader_from_top:\n        print(row)
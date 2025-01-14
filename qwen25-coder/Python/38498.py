import csv\n\n# Sample CSV data as a multiline string\ndata = """,,Joe,Smith,New Haven,CT,"Moved from Portland, CT",,goo,\n,,John,Doe,Boston,MA,North End,,bar,"some info"\n"""\n\n# Split the multiline string into individual lines\nlines = data.strip().split('\n')\n\n# Open a CSV reader with StringIO to simulate reading from a file object\nimport io\n\nwith io.StringIO(data) as f:\n    csv_reader = csv.reader(f)\n    \n    # Process each row (line) in the CSV\n    for row in csv_reader:\n        # Merge fields 6, 7, and 8 (index 5, 6, 7 as indexing starts at 0)\n        merged_field = ', '.join(filter(None, row[5:8]))\n        \n        # Replace the original fields with the merged field\n        new_row = row[:5] + [merged_field] + row[8:]\n        \n        # Print the modified row\n        print(new_row)
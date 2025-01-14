import csv\n\ndef update_csv(file_path, row_index, column_name, new_value):\n    # Read the CSV into memory\n    rows = []\n    with open(file_path, 'r', newline='') as csvfile:\n        reader = csv.DictReader(csvfile)\n        fieldnames = reader.fieldnames\n        for index, row in enumerate(reader):\n            if index == row_index:\n                row[column_name] = new_value\n            rows.append(row)\n\n    # Write the updated CSV back to disk\n    with open(file_path, 'w', newline='') as csvfile:\n        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)\n        writer.writeheader()\n        writer.writerows(rows)\n\n# Example usage: update row 2's 'name' column in 'data.csv'\nupdate_csv('data.csv', 1, 'name', 'New Name')
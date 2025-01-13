import csv\n\nwith open('input.csv', 'r') as input_file, open('output.csv', 'w') as output_file:\n    reader = csv.reader(input_file)\n    writer = csv.writer(output_file)\n\n    # Remove extra commas and rearrange group totals\n    for row in reader:\n        if row[0].startswith('Total'):  # Group total row\n            # Rearrange the row to its correct position\n            writer.writerow(row[1:])\n        else:\n            # Remove extra commas\n            writer.writerow([field for field in row if field.strip()])
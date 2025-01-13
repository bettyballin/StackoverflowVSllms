import csv\n\ndef merge_fields(csv_string):\n    reader = csv.reader(csv_string.splitlines())\n    merged_rows = []\n    for row in reader:\n        merged_row = row[:6] + [' '.join(row[6:9])] + row[9:]\n        merged_rows.append(merged_row)\n    return '\n'.join([','.join(row) for row in merged_rows])\n\n# Example usage:\ncsv_string = ',,Joe,Smith,New Haven,CT,"Moved from Portland, CT",,goo,'\nprint(merge_fields(csv_string))
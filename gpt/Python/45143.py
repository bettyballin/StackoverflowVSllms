import csv\n\ndef utf8_to_ascii(input_file, output_file):\n    with open(input_file, mode='r', encoding='utf-8') as infile, \\n         open(output_file, mode='w', encoding='ascii', errors='ignore') as outfile:\n        reader = csv.reader(infile)\n        writer = csv.writer(outfile)\n        \n        for row in reader:\n            # Convert each cell in the row to ASCII\n            ascii_row = [cell.encode('ascii', errors='ignore').decode('ascii') for cell in row]\n            writer.writerow(ascii_row)\n\n# Example usage\ninput_file = 'input_utf8.csv'\noutput_file = 'output_ascii.csv'\nutf8_to_ascii(input_file, output_file)
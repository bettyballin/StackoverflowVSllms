import glob\nimport csv\nfrom bs4 import BeautifulSoup\n\n# Directory where the HTML files are located\ninput_directory = '/home/phi/data/NHL/pl0708/pl02*.htm'\n# Output CSV file\noutput_csv = 'output.csv'\n\n# Open the output CSV file for writing\nwith open(output_csv, mode='w', newline='') as csv_file:\n    writer = csv.writer(csv_file)\n    \n    # Write the header row if needed\n    writer.writerow(['Column1', 'Column2', 'Column3'])  # Adjust headers as needed\n\n    # Iterate through all matching HTML files\n    for filename in glob.glob(input_directory):\n        # Open and parse the HTML file\n        with open(filename, 'r', encoding='utf-8') as file:\n            soup = BeautifulSoup(file, 'html.parser')\n            \n            # Find all rows with the class 'evenColor'\n            for row in soup.findAll("tr", class_="evenColor"):\n                # Extract text from each cell in the row\n                columns = row.find_all('td')\n                row_data = [col.get_text(strip=True) for col in columns]\n                \n                # Write the row data to the CSV file\n                writer.writerow(row_data)\n\nprint(f'Data has been successfully written to {output_csv}')
import os\n   from bs4 import BeautifulSoup\n   import pandas as pd\n\n   # Directory containing HTML files\n   html_dir = 'path/to/html/files'\n\n   # Function to extract tables from an HTML file\n   def extract_tables_from_html(file_path):\n       with open(file_path, 'r', encoding='utf-8') as file:\n           soup = BeautifulSoup(file, 'html.parser')\n           tables = soup.find_all('table')\n           return [pd.read_html(str(table))[0] for table in tables]\n\n   # Iterate over all HTML files and extract tables\n   all_tables = []\n   for filename in os.listdir(html_dir):\n       if filename.endswith('.html'):\n           file_path = os.path.join(html_dir, filename)\n           tables = extract_tables_from_html(file_path)\n           all_tables.extend(tables)\n\n   # Process the extracted tables as needed\n   for i, table in enumerate(all_tables):\n       print(f"Table {i+1}:")\n       print(table)
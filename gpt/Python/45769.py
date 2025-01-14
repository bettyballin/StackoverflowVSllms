import csv\n\n   # Define the CSV file path\n   csv_file_path = 'path/to/your/file.csv'\n\n   # Define the template for the insert statement\n   insert_template = """\n   INSERT INTO PERSON (ID, NAME, CITY_ID)\n   VALUES (\n       (SELECT NEW_GUID FROM CREATE_GUID),\n       '{name}',\n       (SELECT CITY_ID FROM CITY WHERE NAME = '{city_name}')\n   );\n   """\n\n   # Read the CSV file and generate the SQL statements\n   with open(csv_file_path, mode='r') as file:\n       csv_reader = csv.DictReader(file)\n       for row in csv_reader:\n           name = row['NAME']\n           city_name = row['CITY_NAME']\n           insert_statement = insert_template.format(name=name, city_name=city_name)\n           print(insert_statement)
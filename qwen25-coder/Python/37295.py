import pandas as pd\nimport sqlite3\n\n# Connect to the SQLite database (or create it)\nconn = sqlite3.connect('your_database.db')\n\n# Load CSV file(s) into DataFrame and then write to database\ncsv_files = ['data1.csv', 'data2.csv']  # list your csv files here\nfor filename in csv_files:\n    df = pd.read_csv(filename)\n    table_name = filename.replace('.csv', '')  # name the table after the filename without extension\n    df.to_sql(table_name, conn, if_exists='replace', index=False)\n\n# Close connection\nconn.close()
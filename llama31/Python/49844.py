import psycopg2\n\n# Connect to the database\nconn = psycopg2.connect(\n    host="your_host",\n    database="your_database",\n    user="your_username",\n    password="your_password"\n)\n\n# Create a cursor object\ncur = conn.cursor()\n\n# Define the data to be inserted\ndata = [\n    (1, 'value1', 'value2'),\n    (2, 'value3', 'value4'),\n    # ...\n]\n\n# Create a temporary file-like object with the data\nimport io\nf = io.StringIO()\nfor row in data:\n    f.write('\t'.join(map(str, row)) + '\n')\n\n# Move the file pointer to the beginning\nf.seek(0)\n\n# Execute the COPY command\ncur.copy_from(f, 'your_table', columns=('column1', 'column2', ...))\n\n# Commit the transaction\nconn.commit()
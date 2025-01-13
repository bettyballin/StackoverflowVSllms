from flask import Flask, g\nimport mysql.connector\n\napp = Flask(__name__)\n\n# MySQL configuration\nconfig = {\n    'user': 'your_username',\n    'password': 'your_password',\n    'host': 'your_host',\n    'database': 'your_database'\n}\n\n# Connect to MySQL\ncnx = mysql.connector.connect(**config)\n\n# Define a route\n@app.route('/')\ndef index():\n    cursor = cnx.cursor()\n    cursor.execute("SELECT * FROM your_table")\n    rows = cursor.fetchall()\n    return "Hello, World! {}".format(rows)\n\n# Close the MySQL connection\n@app.teardown_appcontext\ndef close_connection(exception):\n    cnx.close()\n\nif __name__ == '__main__':\n    app.run(debug=True)
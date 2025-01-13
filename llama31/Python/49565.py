from flask import Flask, jsonify, request\nimport sqlite3\n\napp = Flask(__name__)\n\n# Define an API endpoint\n@app.route('/data', methods=['GET'])\ndef get_data():\n    conn = sqlite3.connect('server_database.db')\n    cursor = conn.cursor()\n    cursor.execute("SELECT * FROM my_table")\n    data = cursor.fetchall()\n    conn.close()\n    return jsonify(data)\n\nif __name__ == '__main__':\n    app.run(debug=True)
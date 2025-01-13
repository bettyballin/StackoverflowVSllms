# Example using Flask\nfrom flask import Flask, jsonify\napp = Flask(__name__)\n\n@app.route('/api/data', methods=['GET'])\ndef get_data():\n    data = {'name': 'John', 'age': 30}\n    return jsonify(data)\n\nif __name__ == '__main__':\n    app.run(debug=True)
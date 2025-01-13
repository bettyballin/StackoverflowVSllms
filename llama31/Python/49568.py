# Server\nfrom flask import Flask, jsonify\n\napp = Flask(__name__)\n\n@app.route('/api/data', methods=['GET'])\ndef get_data():\n    return jsonify({'data': 'Hello, world!'})\n\nif __name__ == '__main__':\n    app.run(debug=True)\n\n# Client\nimport requests\n\nresponse = requests.get('http://localhost:5000/api/data')\nprint(response.json())
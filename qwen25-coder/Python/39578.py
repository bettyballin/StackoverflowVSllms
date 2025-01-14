from flask import Flask, jsonify\n\napp = Flask(__name__)\n\n@app.after_request\ndef add_cors_headers(response):\n    response.headers['Access-Control-Allow-Origin'] = '*'\n    return response\n\n@app.route('/example')\ndef example():\n    return jsonify({'data': 'Hello, world!'})\n\nif __name__ == '__main__':\n    app.run(port=5000)
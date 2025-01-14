from flask import Flask, jsonify\n\napp = Flask(__name__)\n\n@app.route('/')\ndef home():\n    try:\n        # Normal processing\n        return jsonify(message="Hello, World!"), 200\n    except Exception as e:\n        # Handle errors and set appropriate response code\n        return jsonify(error=str(e)), 500\n\nif __name__ == '__main__':\n    app.run(debug=True)
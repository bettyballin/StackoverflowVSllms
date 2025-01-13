import requests\nfrom flask import Flask\n\napp = Flask(__name__)\n\n@app.route('/query')\ndef query_app():\n    # Make a request to the basic app to get data\n    response = requests.get('http://localhost:5001/data')\n    data = response.json()\n    return f"Received data: {data}"\n\nif __name__ == '__main__':\n    app.run(port=5000)
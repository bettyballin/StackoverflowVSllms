from flask import Flask\n\napp = Flask(__name__)\n\n@app.route('/')\ndef home():\n    return 'Hello, World!', 200\n\nif __name__ == '__main__':\n    app.run()
from flask import Flask, render_template\n\napp = Flask(__name__)\n\n@app.route('/')\ndef home():\n    return "Hello, World!"\n\nif __name__ == '__main__':\n    app.run(debug=True)
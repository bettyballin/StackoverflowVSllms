from flask import Flask, render_template, request\n\n   app = Flask(__name__)\n\n   @app.route('/', defaults={'path': ''})\n   @app.route('/<path:path>')\n   def index(path):\n       # Here you can handle routing similarly to your PHP setup\n       full_path = path if path else 'index'\n       return render_template('index.html', flashvar=path)\n\n   if __name__ == '__main__':\n       app.run(debug=True)
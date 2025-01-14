from flask import Flask, request, Response\nfrom flask_httpauth import HTTPBasicAuth\n\napp = Flask(__name__)\nauth = HTTPBasicAuth()\n\nusers = {"john": "hello"}\n\n@auth.verify_password\ndef verify_password(username, password):\n    if username in users and users[username] == password:\n        return username\n\n@app.route('/')\n@auth.login_required\ndef index():\n    return f"Hello, {auth.current_user()}!"\n\nif __name__ == '__main__':\n    app.run(ssl_context='adhoc')  # Use SSL for secure connections
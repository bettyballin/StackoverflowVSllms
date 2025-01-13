from flask import Flask, request, abort\nimport re\n\napp = Flask(__name__)\n\n@app.route('/')\ndef index():\n    i = request.args.get('i')\n    p = request.args.get('p')\n\n    # Validate that 'i' is an integer\n    if not i.isdigit():\n        abort(400, description="Invalid 'i' parameter")\n\n    # Validate that 'p' contains only letters and/or numbers\n    if not re.match("^[a-zA-Z0-9]+$", p):\n        abort(400, description="Invalid 'p' parameter")\n\n    # Continue with your logic\n    return f"i: {i}, p: {p}"\n\nif __name__ == '__main__':\n    app.run()
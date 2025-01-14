from flask import Flask, request\nfrom redis import Redis\n\napp = Flask(__name__)\ncache = Redis(host='localhost', port=6379)\n\n@app.route('/')\ndef index():\n    cached_content = cache.get('index')\n    if cached_content:\n        return cached_content\n    content = "Welcome to our scalable website!"\n    cache.setex('index', 3600, content)  # Cache for 1 hour\n    return content\n\nif __name__ == '__main__':\n    app.run(host='0.0.0.0', port=5000)
from flask import Flask, request\n\napp = Flask(__name__)\n\n@app.route('/search', methods=['POST'])\ndef search_post():\n    query = request.form['query']\n    # Perform search using query\n    return 'Search results'\n\n@app.route('/search/<string:query>', methods=['GET'])\ndef search_get(query):\n    # Perform search using query\n    return 'Search results'
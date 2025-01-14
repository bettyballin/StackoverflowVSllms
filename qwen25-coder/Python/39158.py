from flask import Flask, request, jsonify\n\napp = Flask(__name__)\n\n# Mock ACL rules for demonstration purposes\nacl_rules = {\n    'user1': ['read', 'write'],\n    'user2': ['read']\n}\n\n@app.route('/authorize/<username>/<action>', methods=['GET'])\ndef authorize(username, action):\n    permissions = acl_rules.get(username, [])\n    if action in permissions:\n        return jsonify({"authorized": True}), 200\n    else:\n        return jsonify({"authorized": False}), 403\n\nif __name__ == '__main__':\n    app.run(port=5001)
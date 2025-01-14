from flask import Flask, request, jsonify\nfrom werkzeug.security import generate_password_hash, check_password_hash\nimport uuid\n\napp = Flask(__name__)\n\n# Simulated database\nusers_db = {}\n\ndef is_password_unique(password):\n    return not any(check_password_hash(user['password'], password) for user in users_db.values())\n\n@app.route('/register', methods=['POST'])\ndef register():\n    password = request.json.get('password')\n    \n    if not is_password_unique(password):\n        return jsonify({"error": "Password is already in use. Please choose a different password."}), 400\n\n    user_id = str(uuid.uuid4())\n    hashed_password = generate_password_hash(password)\n    users_db[user_id] = {"password": hashed_password}\n    \n    return jsonify({"message": "User registered successfully.", "user_id": user_id})\n\n@app.route('/login', methods=['POST'])\ndef login():\n    password = request.json.get('password')\n    \n    for user_id, user in users_db.items():\n        if check_password_hash(user['password'], password):\n            return jsonify({"message": "Login successful.", "user_id": user_id})\n    \n    return jsonify({"error": "Invalid password."}), 401\n\nif __name__ == '__main__':\n    app.run(debug=True)
from flask import Flask, request, redirect, render_template_string\nimport uuid\n\napp = Flask(__name__)\n\n# Simulated user database and email verification tokens\nusers = {}\nverification_codes = {}\n\n@app.route('/register', methods=['GET', 'POST'])\ndef register():\n    if request.method == 'POST':\n        email = request.form['email']\n        \n        # Generate a unique GUID for the email verification link\n        guid = str(uuid.uuid4())\n        verification_codes[guid] = email\n        users[email] = {'is_verified': False}\n\n        # Simulate sending an email with the verification link\n        print(f"Send an email to {email} with confirmation link: http://localhost/verify/{guid}")\n\n        return "An email has been sent. Please verify your address."\n    \n    return '''\n        <form method="post">\n            Email: <input type="text" name="email"><br>\n            <input type="submit" value="Register">\n        </form>\n    '''\n\n@app.route('/verify/<token>')\ndef verify(token):\n    if token in verification_codes:\n        email = verification_codes[token]\n        users[email]['is_verified'] = True\n        del verification_codes[token]\n        return "Email verified successfully!"\n    \n    return "Invalid verification link."\n\nif __name__ == '__main__':\n    app.run(debug=True)
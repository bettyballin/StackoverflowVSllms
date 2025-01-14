# Example of server-side validation in Flask with a simple CAPTCHA\nfrom flask import Flask, request, render_template_string\n\napp = Flask(__name__)\n\n# Dummy function to simulate checking the captcha against a valid response\ndef is_captcha_correct(user_input, session_captcha):\n    return user_input.strip().lower() == session_captcha.strip().lower()\n\n@app.route('/register', methods=['GET', 'POST'])\ndef register():\n    if request.method == 'POST':\n        user_input = request.form['captcha']\n        # Assume correct_captcha is retrieved from a secure session or database\n        correct_captcha = "somerandomword"\n        if is_captcha_correct(user_input, correct_captcha):\n            return "Registration Successful!"\n        else:\n            return "CAPTCHA incorrect. Please try again."\n    # Render a form with the CAPTCHA here\n    return render_template_string('''\n        <form method="post">\n            Enter CAPTCHA: somerandomword<br />\n            <input type="text" name="captcha" required><br />\n            <button type="submit">Register</button>\n        </form>\n    ''')\n\nif __name__ == '__main__':\n    app.run(debug=True)
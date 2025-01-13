from flask import Flask, request, render_template, url_for\nfrom itsdangerous import URLSafeTimedSerializer\nfrom flask_mail import Mail, Message\n\napp = Flask(__name__)\napp.config['SECRET_KEY'] = 'your_secret_key'\napp.config['MAIL_SERVER'] = 'smtp.example.com'\napp.config['MAIL_PORT'] = 587\napp.config['MAIL_USERNAME'] = 'your_email@example.com'\napp.config['MAIL_PASSWORD'] = 'your_email_password'\napp.config['MAIL_USE_TLS'] = True\napp.config['MAIL_USE_SSL'] = False\n\nmail = Mail(app)\nserializer = URLSafeTimedSerializer(app.config['SECRET_KEY'])\n\n@app.route('/reset_password', methods=['POST'])\ndef reset_password():\n    email = request.form['email']\n    token = serializer.dumps(email, salt='password-reset-salt')\n    reset_url = url_for('reset_with_token', token=token, _external=True)\n    message = Message(subject="Password Reset Request",\n                      sender="your_email@example.com",\n                      recipients=[email],\n                      body=f"To reset your password, click the following link: {reset_url}")\n    mail.send(message)\n    return "A password reset link has been sent to your email address."\n\n@app.route('/reset/<token>', methods=['GET', 'POST'])\ndef reset_with_token(token):\n    try:\n        email = serializer.loads(token, salt='password-reset-salt', max_age=3600)\n    except:\n        return "The password reset link is invalid or has expired."\n    \n    if request.method == 'POST':\n        new_password = request.form['password']\n        # Update the user's password in your database here\n        return "Your password has been updated!"\n    return render_template('reset_password.html')\n\nif __name__ == '__main__':\n    app.run(debug=True)
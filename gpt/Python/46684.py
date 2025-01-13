from flask import Flask, redirect, url_for, flash\n\napp = Flask(__name__)\napp.secret_key = 'your_secret_key'\n\n@app.route('/admin')\ndef admin():\n    if not user_is_authenticated() or not user_is_admin():\n        flash('You do not have permission to access the admin area. Please contact the administrator if you believe this is an error.')\n        return redirect(url_for('home'))\n    return 'Welcome to the admin area!'\n\ndef user_is_authenticated():\n    # Implement your authentication logic here\n    return False\n\ndef user_is_admin():\n    # Implement your admin check logic here\n    return False\n\n@app.route('/')\ndef home():\n    return 'Welcome to the home page!'\n\nif __name__ == '__main__':\n    app.run()
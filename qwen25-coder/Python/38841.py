@app.route('/greet/<name>')\ndef greet(name):\n    return render_template('base.html', title="Greeting", header=f"Hello, {name}!", content="Welcome to the website.")
# Insecure code\npassword = request.form['password']\ncursor.execute("SELECT * FROM users WHERE password = '%s'" % password)\n\n# Secure code\npassword = request.form['password']\nhashed_password = hash_password(password)\ncursor.execute("SELECT * FROM users WHERE password = '%s'" % hashed_password)
$salt = 'random-salt-string';\n$password = 'myfakelongrandompasswordstring';\n$hashedPassword = hash('sha256', $salt . $password);
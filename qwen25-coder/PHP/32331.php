<?php\n$password = 'hello';\n$hash = password_hash($password, PASSWORD_BCRYPT);\n// Now insert the hash into your database
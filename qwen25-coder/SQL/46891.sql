USE mysql;\n     UPDATE user SET authentication_string=PASSWORD('new_password') WHERE User='root';\n     FLUSH PRIVILEGES;\n     QUIT;
use libsodium;\n\n$crypted_password = file_get_contents('db_password.enc');\n$db_password = libsodium::crypto_secretbox_open($crypted_password, $secret_key);
$password = "ThisIsMyKey";\n$salt = ''; // Empty salt, similar to OpenSSL\n$keySize = mcrypt_enc_get_key_size($td);\n$iterations = 1;\n\n$key = hash_pbkdf2('md5', $password, $salt, $iterations, $keySize, true);\n$iv = hash_pbkdf2('md5', $password, $salt, $iterations, mcrypt_enc_get_iv_size($td), true);
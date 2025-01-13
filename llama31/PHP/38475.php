use Phpass\Hash;\n\n$username = 'username';\n$password = 'password';\n\n$hash = new Hash();\n$encrypted_password = $hash->hashPassword($password);\n\n$htpasswd_line = "$username:$encrypted_password";\n\n// Write the line to the htpasswd file\n$file = fopen('htpasswd', 'a');\nfwrite($file, $htpasswd_line . "\n");\nfclose($file);
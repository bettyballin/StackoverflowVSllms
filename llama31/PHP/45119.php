$username = 'your_username';\n$password = 'your_password';\n\n$url = 'https://service.com/signin.php';\n\n$data = array(\n    'username' => $username,\n    'password' => $password\n);\n\n$ch = curl_init($url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\ncurl_setopt($ch, CURLOPT_POST, true);\ncurl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));\ncurl_setopt($ch, CURLOPT_SSL_VERIFYPEER, true);\n\n$response = curl_exec($ch);\n\ncurl_close($ch);\n\n// Check the response to see if the login was successful
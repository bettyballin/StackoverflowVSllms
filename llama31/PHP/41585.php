$wsdl = 'https://qa-api.ukmail.com/Services/UKMAuthenticationServices/UKMAuthenticationService.svc?wsdl';\n$client = new SoapClient($wsdl);\n\n$username = 'your_username';\n$password = 'your_password';\n\n$params = array(\n    'username' => $username,\n    'password' => $password\n);\n\n$response = $client->Login($params);\n\nif ($response->LoginResult-> StatusCode == 'Success') {\n    echo 'Login successful!';\n} else {\n    echo 'Login failed: ' . $response->LoginResult-> ErrorMessage;\n}
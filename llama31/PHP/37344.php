# PHP app (client)\nuse GuzzleHttp\Client;\n\n$client = new Client();\n\n// Redirect user to authorization endpoint\n$url = 'http://www.b.com/authorize?client_id=your_client_id&response_type=code';\nheader('Location: ' . $url);\n\n// Handle callback with authorization code\n$code = $_GET['code'];\n// Exchange code for access token\n$response = $client->post('http://www.b.com/token', ['code' => $code]);\n$token = json_decode($response->getBody(), true)['access_token'];\n\n// Use access token to authenticate user on Django app
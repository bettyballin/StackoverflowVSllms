use GuzzleHttp\Client;\n\n$client = new Client();\n$response = $client->post('http://backend-server.com/process.php', ['form_params' => ['key' => 'value']]);\n\necho $response->getBody()->getContents(); // output response from backend server
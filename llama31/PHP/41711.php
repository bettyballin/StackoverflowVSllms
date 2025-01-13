use GuzzleHttp\Client;\n\n$client = new Client(['base_uri' => 'https://your-backend-api.com/api/']);\n\n$response = $client->get('MyController');\n\nif ($response->getStatusCode() == 200) {\n    $data = json_decode($response->getBody()->getContents(), true);\n    echo $data['data']; // Output: Hello, World!\n}
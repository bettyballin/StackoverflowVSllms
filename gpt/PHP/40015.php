use Symfony\Component\HttpFoundation\Cookie;\nuse Symfony\Component\HttpFoundation\Response;\n\n// Assuming you have an array of data\n$dataArray = ['key1' => 'value1', 'key2' => 'value2'];\n\n// Serialize the array to JSON\n$jsonData = json_encode($dataArray);\n\n// Create a new cookie\n$cookie = new Cookie('myCookie', $jsonData, strtotime('now + 1 week'));\n\n// Create a response object\n$response = new Response();\n\n// Set the cookie in the response\n$response->headers->setCookie($cookie);\n\n// Send the response\n$response->send();
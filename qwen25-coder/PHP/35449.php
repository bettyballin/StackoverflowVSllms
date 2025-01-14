use Symfony\Component\HttpFoundation\Response;\n\n$data = ['key' => 'value', 'another_key' => 'another_value'];\n\n// Encode the array to JSON\n$jsonData = json_encode($data);\n\n$response = new Response();\n$response->setCookie('myCookie', $jsonData);\n\n// To retrieve and decode:\nif ($request->cookies->has('myCookie')) {\n    $cookieValue = $request->cookies->get('myCookie');\n    $dataFromCookie = json_decode($cookieValue, true);\n}
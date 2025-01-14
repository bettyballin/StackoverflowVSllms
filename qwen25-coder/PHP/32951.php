$client = new SoapClient("http://blackbird.integrated.local/PricingTool/WebService.asmx?WSDL", \n  array('trace' => true));\n\n// Call the SOAP function and store the result in a variable\n$response = $client->GetDAAAvailablility(array('PartNo' => '100C'));\n\n// Print the response object. It's an object, so you can access its properties.\nprint_r($response);\n\n// Alternatively, if you know the structure of the response and want to access specific data:\nif (property_exists($response, 'GetDAAAvailablilityResult')) {\n    echo $response->GetDAAAvailabliliyResult;\n}
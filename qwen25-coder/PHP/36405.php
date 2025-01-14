// Define the WSDL URL and create a SoapClient instance\n$wsdl = "http://localhost:16840/CTI.ConfigStack.WS/ATeamService.asmx?WSDL";\n$client = new SoapClient($wsdl, array('trace' => 1));\n\n// Prepare the data for the header\n$headerData = new stdClass();\n$headerData->UserId = 'your_user_id'; // Replace with actual user id\n\n// Create a new SoapHeader instance\n$authHeader = new SoapHeader('http://www.example.com/namespace', 'AuthorisationHeader', $headerData);\n\n// Add the SOAP Header to the client\n$client->__setSoapHeaders($authHeader);\n\n// Prepare parameters for the method\n$params = array(\n    'users' => ..., // Your users data here\n    'templateUserId' => 3\n);\n\n// Make the SOAP call\ntry {\n    $result = $client->AddPendingUsers($params);\n    print_r($result);\n} catch (SoapFault $e) {\n    echo "Request Error:\n";\n    print_r($e);\n}
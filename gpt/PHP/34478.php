// Define the namespace and header data\n$namespace = "http://tempuri.org/"; // Replace with the correct namespace\n$headername = "AuthorisationHeader";\n$headerdata = array(\n    'UserId' => 'your_user_id', // Replace with the actual user ID\n    'Password' => 'your_password' // Replace with the actual password\n);\n\n// Create the SoapHeader object\n$header = new SoapHeader($namespace, $headername, $headerdata);\n\n// Create the SoapClient object with the WSDL\n$service = new SoapClient("http://localhost:16840/CTI.ConfigStack.WS/ATeamService.asmx?WSDL");\n\n// Set the SoapHeader in the SoapClient\n$service->__setSoapHeaders($header);\n\n// Define the parameters for the AddPendingUsers method\n$users = array(); // Populate with actual user data\n$templateUserId = 3;\n\n// Call the AddPendingUsers method\n$result = $service->AddPendingUsers($users, $templateUserId);\n\n// Print the result\nprint_r($result);
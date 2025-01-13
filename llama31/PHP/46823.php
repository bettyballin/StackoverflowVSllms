// Create a SOAP server\n$soapServer = new SoapServer(null, array('uri' => 'http://your-linux-box/quickbooks'));\n\n// Define the QuickBooks Web Connector's API methods\nfunction authenticate($strUserName, $strPassword) {\n  // Authenticate with QuickBooks\n}\n\nfunction sendRequestXML($strHCPResponse, $strCompanyFileName, $qbXMLMajorVers, $qbXMLMinorVers) {\n  // Process the request from QuickBooks\n}\n\n// Add more API methods as needed...\n\n// Register the API methods with the SOAP server\n$soapServer->addFunction('authenticate');\n$soapServer->addFunction('sendRequestXML');\n\n// Start the SOAP server\n$soapServer->handle();
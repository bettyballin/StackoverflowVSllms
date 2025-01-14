<?php\n\n$options = array(\n    'location' => "https://example.com/soap/service",\n    'uri'      => "urn:my-service-namespace",\n    'login'    => "yourUsername",\n    'password' => "yourPassword",\n    'trace'    => 1, // Enable this to see SOAP messages in case of errors\n);\n\n$client = new SoapClient(NULL, $options);\n$client->__setLocation("https://example.com/soap/service");\n\n// Adding WS-Security Headers if necessary (this is a simple example)\n$wsseSecurityHeader = new stdClass();\n$wsseSecurityHeader->UsernameToken = new stdClass();\n$wsseSecurityHeader->UsernameToken->Username = "yourUsername";\n$wsseSecurityHeader->UsernameToken->Password = "yourPassword";\n\n// Encoding the security header as SOAP var\n$security_header = new SoapVar($wsseSecurityHeader, SOAP_ENC_OBJECT, 'Security', 'http://schemas.xmlsoap.org/ws/2003/06/secext');\n\n// Adding to headers queue of SOAP client\n$client->__setSoapHeaders(new SoapHeader('http://schemas.xmlsoap.org/ws/2003/06/secext', 'Security', $security_header, true));\n\ntry {\n    // Example function call\n    $result = $client->YourServiceFunction(array());\n    print_r($result);\n} catch (Exception $e) {\n    echo "Error: " . $e->getMessage();\n}\n?>
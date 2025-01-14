function myErrorHandler($request) {\n    // Attempt to initialize the SOAP server\n    $server = new SoapServer("your_wsdl.wsdl");\n\n    // Define a function that throws an exception if input is incorrect\n    function handleData($params) {\n        try {\n            if (!is_bool($params->EmailBlast)) {\n                throw new Exception("EmailBlast must be a boolean");\n            }\n            if (!filter_var($params->PublishRadius, FILTER_VALIDATE_INT) !== false) {\n                throw new Exception("PublishRadius must be an integer");\n            }\n\n            // Your existing logic here\n            return "Success";\n        } catch (Exception $e) {\n            throw new SoapFault('Client', $e->getMessage());\n        }\n    }\n\n    // Attach the function to handle requests\n    $server->addFunction('handleData');\n\n    try {\n        $server->handle($request);\n    } catch (Exception $e) {\n        return new SoapFault('Server', 'An error occurred: ' . $e->getMessage());\n    }\n}\n\n// Example usage, typically this would be where the server is initialized and waits for requests\n$request = file_get_contents("php://input");\n$response = myErrorHandler($request);\n\n// Send response back to client\necho $response;
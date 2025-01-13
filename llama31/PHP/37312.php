$server = new SoapServer($wsdl, $options);\n\n$server->setClass('MySoapService');\n\n$server->handle();\n\nclass MySoapService {\n    public function myMethod($params) {\n        $headers = $this->getHeaders();\n        $email = $headers['email'];\n        $password = $headers['password'];\n\n        // Process authentication here\n    }\n\n    private function getHeaders() {\n        $headers = array();\n        if (isset($_SERVER['HTTP_SOAPACTION'])) {\n            $action = $_SERVER['HTTP_SOAPACTION'];\n            $headers = explode(' ', $action);\n            $headers = array_combine(array('email', 'password'), array_slice($headers, 1));\n        }\n        return $headers;\n    }\n}
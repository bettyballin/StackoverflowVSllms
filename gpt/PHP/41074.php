class MultipartSoapClient extends SoapClient {\n    \n    public function __doRequest($request, $location, $action, $version, $one_way = 0) {\n        $response = parent::__doRequest($request, $location, $action, $version, $one_way);\n\n        // Handle multi-part response\n        if (strpos($response, "Content-Type: multipart/") !== false) {\n            $parts = $this->parseMultipart($response);\n            // Assuming the first part is the SOAP envelope\n            $response = $parts[0];\n        }\n\n        return $response;\n    }\n\n    private function parseMultipart($response) {\n        $boundary = $this->getBoundary($response);\n        $parts = explode("--" . $boundary, $response);\n        \n        // Remove the first and last elements as they are not needed\n        array_shift($parts);\n        array_pop($parts);\n\n        return $parts;\n    }\n\n    private function getBoundary($response) {\n        preg_match('/boundary="([^"]+)"/', $response, $matches);\n        return $matches[1];\n    }\n}\n\n// Usage\n$options = [\n    'location' => 'http://example.com/soap',\n    'uri' => 'http://example.com/soap/namespace',\n];\n\n$client = new MultipartSoapClient(null, $options);\n$result = $client->__soapCall('yourSoapMethod', [$yourParameters]);\n\nprint_r($result);
class WSSoapClient extends SoapClient {\n    private $username;\n    private $password;\n\n    public function __construct($wsdl, $options, $username, $password) {\n        parent::__construct($wsdl, $options);\n        $this->username = $username;\n        $this->password = $password;\n    }\n\n    private function createWSSEHeader() {\n        $nonce = mt_rand();\n        $timestamp = gmdate('Y-m-d\TH:i:s\Z');\n        $passdigest = base64_encode(sha1($nonce . $timestamp . $this->password, true));\n\n        $wsseHeader = '\n            <wsse:Security SOAP-ENV:mustUnderstand="1" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd">\n                <wsse:UsernameToken>\n                    <wsse:Username>' . $this->username . '</wsse:Username>\n                    <wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest">' . $passdigest . '</wsse:Password>\n                    <wsse:Nonce>' . base64_encode($nonce) . '</wsse:Nonce>\n                    <wsu:Created xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">' . $timestamp . '</wsu:Created>\n                </wsse:UsernameToken>\n            </wsse:Security>';\n\n        $dom = new DOMDocument();\n        $dom->loadXML($wsseHeader);\n\n        return new SoapVar($dom->documentElement, XSD_ANYXML);\n    }\n\n    public function __doRequest($request, $location, $action, $version, $one_way = 0) {\n        $wsseHeader = $this->createWSSEHeader();\n        $soapVar = new SoapVar($wsseHeader, XSD_ANYXML);\n        $header = new SoapHeader('http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd', 'Security', $soapVar, true);\n\n        $this->__setSoapHeaders($header);\n\n        return parent::__doRequest($request, $location, $action, $version, $one_way);\n    }\n}\n\n// Usage\n$wsdl = "https://example.com/WSDL/nameofservice";\n$options = array('trace' => 1, 'exceptions' => 1);\n$username = "your_username";\n$password = "your_password";\n\ntry {\n    $client = new WSSoapClient($wsdl, $options, $username, $password);\n    // Now you can call methods on the $client as needed\n    $response = $client->__soapCall("YourMethodName", array(/* parameters */));\n    print_r($response);\n} catch (SoapFault $fault) {\n    echo "Error: {$fault->faultcode}, {$fault->faultstring}";\n}
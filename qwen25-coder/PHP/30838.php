$options = [\n    'local_cert' => "path/to/server_and_key.pem",  // Concatenated server cert and key\n    'passphrase' => "your_pass_phrase",            // If your private key is encrypted\n    'cafile'     => "path/to/ca-cert.pem",          // CA certificate\n    'ssl_method' => SOAP_SSL_METHOD_TLSv1_2,        // Specify the SSL method if necessary\n];\n\n$client = new SoapClient("some.wsdl", $options);
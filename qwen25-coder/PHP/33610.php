class pushNotifications {\n    ...\n    private $sslPem = '/Users/jamey/Sites/cert.pem'; // Use absolute path for testing\n\n    function connectToAPNS(){\n         $streamContext = stream_context_create();\n         stream_context_set_option($streamContext, 'ssl', \n            'local_cert', $this->sslPem);\n         ...\n    }\n}
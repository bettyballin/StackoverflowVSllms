$client = new SoapClient($wsdlPath, array(\n    // ... other options ...\n    'cache_wsdl' => WSDL_CACHE_NONE,\n));
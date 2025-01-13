$newIncludePath = array();\n$newIncludePath[] = '../ZendGdata-1.8.4PL1/library';\n$newIncludePath = implode($newIncludePath);\nset_include_path($newIncludePath);\n\n// load classes\nrequire_once 'Zend/Loader.php';\nZend_Loader::loadClass('Zend_Gdata');\nZend_Loader::loadClass('Zend_Gdata_ClientLogin');\nZend_Loader::loadClass('Zend_Gdata_Calendar');\nZend_Loader::loadClass('Zend_Http_Client');\nZend_Loader::loadClass('Zend_Gdata_AuthSub');\n\nsession_start();\n\n$serviceName = Zend_Gdata_Calendar::AUTH_SERVICE_NAME; // predefined service name ('cl') for calendar\n$applicationName = 'yourCompany-yourAppName-v1';\n\n// Create an authenticated HTTP client\n$httpClient = Zend_Gdata_ClientLogin::getHttpClient('*****@gmail.com', '*****', $serviceName, null, $applicationName);\n$client = new Zend_Gdata_Calendar($httpClient, $applicationName); // Create an instance of the Calendar service\n\n$_SESSION['gdataCal'] = $client;
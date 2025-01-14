class My_Controller_Plugin_SslEnforcer extends Zend_Controller_Plugin_Abstract {\n    public function routeShutdown(Zend_Controller_Request_Abstract $request) {\n        // Check if the request is secure (HTTPS)\n        if (!$request->isSecure()) {\n            // Get the current URL without scheme\n            $currentUrl = $request->getRequestUri();\n            \n            // Construct the HTTPS URL\n            $sslUrl = 'https://' . $_SERVER['HTTP_HOST'] . $currentUrl;\n            \n            // Redirect to the SSL version of the page with a 301 Moved Permanently status code\n            $response = new Zend_Controller_Response_Http();\n            $response->setRedirect($sslUrl, 301);\n            $response->sendHeaders();\n            exit;\n        }\n    }\n}
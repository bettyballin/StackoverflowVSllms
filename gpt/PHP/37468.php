use Zend\Http\PhpEnvironment\Request;\n\n$request = new Request();\n$uri = $request->getUri();\n$fullUrl = $uri->toString();\n\necho $fullUrl;
from SOAPpy import WSDL\nimport urllib.request\n\n# Create a handler that follows HTTP redirection\nopener = urllib.request.build_opener(urllib.request.HTTPRedirectHandler())\nurllib.request.install_opener(opener)\n\nserver = WSDL.Proxy('http://my.domain.com/my/webservice', namespace)\nresult = server.myFunction()\nprint(result)
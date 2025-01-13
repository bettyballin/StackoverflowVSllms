// Example of POCO HTTPClient\n  Poco::URI uri("http://example.com");\n  Poco::Net::HTTPClientSession session(uri.getHost(), uri.getPort());\n  Poco::Net::HTTPRequest request(Poco::Net::HTTPRequest::HTTP_GET, uri.getPathAndQuery());\n  Poco::Net::HTTPResponse response;\n\n  session.sendRequest(request);\n  std::istream& rs = session.receiveResponse(response);\n  std::string responseBody(std::istreambuf_iterator<char>(rs), {});
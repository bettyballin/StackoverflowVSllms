header('HTTP/1.1 401 Unauthorized');\nheader('WWW-Authenticate: Basic realm="My Realm"');\nexit;
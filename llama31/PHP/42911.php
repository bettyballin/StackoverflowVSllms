header('WWW-Authenticate: Basic realm="Enter your Twitter username and password:"', false);\nheader('HTTP/1.0 401 Unauthorized');\nexit();
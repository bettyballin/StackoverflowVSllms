$fp = stream_socket_client("tls://smtp.gmail.com:587", $errno, $errstr, 30, STREAM_CLIENT_CONNECT);
$ch = curl_init();\n\ncurl_setopt($ch, CURLOPT_URL, "https://secure.paymentgateway.com/blah.php");\ncurl_setopt($ch, CURLOPT_USERAGENT, "Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0)");\ncurl_setopt($ch, CURLOPT_VERBOSE, 1);\n\n// Set SSL options\ncurl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 2); // Verify the host\ncurl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 1); // Verify the peer\ncurl_setopt($ch, CURLOPT_CAINFO, getcwd().'/cert/ca.crt'); // Set the CA certificate\ncurl_setopt($ch, CURLOPT_SSLCERT, getcwd().'/cert/mycert.pem'); // Set your certificate\ncurl_setopt($ch, CURLOPT_SSLCERTPASSWD, 'password'); // Set your certificate password\n\ncurl_setopt($ch, CURLOPT_POST, $count);\ncurl_setopt($ch, CURLOPT_POSTFIELDS, "variables...");\n\n$output = curl_exec($ch);\necho $output;\ncurl_close($ch);
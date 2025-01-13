function is_available($url, $timeout = 30) {\n    $ch = curl_init(); // get cURL handle\n\n    // set cURL options\n    $opts = array(CURLOPT_RETURNTRANSFER => true, // do not output to browser\n                  CURLOPT_URL => $url,            // set URL\n                  CURLOPT_NOBODY => true,         // do a HEAD request only\n                  CURLOPT_TIMEOUT => $timeout);   // set timeout\n    curl_setopt_array($ch, $opts); \n\n    curl_exec($ch); // do it!\n\n    $retval = curl_getinfo($ch, CURLINFO_HTTP_CODE) == 200; // check if HTTP OK\n\n    curl_close($ch); // close handle\n\n    return $retval;\n}
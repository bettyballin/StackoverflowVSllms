<?php\n$cookieString = $_SERVER['HTTP_COOKIE'];\nparse_str(str_replace('; ', '&', $cookieString), $cookies);\necho $cookies['x.y']; // Outputs: value of x.y cookie if set\n?>
<?php\n\n$regex = '/(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.' .\n         '(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)/';\n$string = "127.255.0.0";\n\npreg_match_all($regex, $string, $matches);\nprint_r($matches[0]);  // Output will be an array with the matched IP address\n?>
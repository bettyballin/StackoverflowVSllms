$maxRetries = 10;\n$retries = 0;\n\ndo {\n    $response = queryAlexaApi(); // your API query function\n    $retries++;\n} while (strpos($response, 'AuthFailure') !== false && $retries < $maxRetries);\n\nif (strpos($response, 'AuthFailure') !== false) {\n    // all retries failed, handle error\n} else {\n    // query was successful, process response\n}
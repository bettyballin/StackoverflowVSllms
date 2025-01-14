<?php\n\n$url = "http://example.com"; // Replace with your URL\n\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n// Collect headers into an array\n$headers = [];\n$cookie_array = [];\n\n// Define a callback to handle each header line\n$headerFunction = function($curl, $header) use (&$headers, &$cookie_array) {\n    $len = strlen($header);\n    if (strpos($header, 'Set-Cookie:') !== false) {\n        // Extract the cookie part\n        list(,$cookie_line) = explode(':', $header, 2);\n        array_push($headers, trim($cookie_line));\n        \n        // Split each cookie into its components and store in an associative array\n        $cookies = explode(';', $cookie_line);\n        foreach ($cookies as &$cookie) {\n            if (!empty(trim($cookie))) {\n                list($key, $value) = array_map('trim', explode('=', $cookie, 2));\n                $cookie_array[$key] = $value;\n            }\n        }\n    }\n    return $len; // Return the length of the header line\n};\n\ncurl_setopt($ch, CURLOPT_HEADERFUNCTION, $headerFunction);\n\n// Execute the request\n$response = curl_exec($ch);\n\ncurl_close($ch);\n\nprint_r($cookie_array); // Output cookies as an associative array\n\n?>
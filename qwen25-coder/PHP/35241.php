<?php\n\nfunction parseMultipartFormData($boundary, $rawPostData) {\n    // Split the content by the main boundary\n    $parts = explode("--{$boundary}", $rawPostData);\n    \n    $data = [];\n    \n    foreach ($parts as $part) {\n        // Trim whitespace and check if empty part or closing boundary\n        $part = trim($part);\n        if (empty($part) || preg_match('/--$/', $part)) continue;\n        \n        // Split headers from body content\n        @list($header, $body) = explode("\r\n\r\n", $part, 2);\n\n        // Parse headers for content type and any other relevant info\n        $headers = [];\n        foreach (explode("\n", $header) as $line) {\n            if (strpos($line, ': ') !== false) {\n                @list($key, $value) = explode(': ', trim($line), 2);\n                $headers[strtolower($key)] = $value;\n            }\n        }\n\n        // If sub-boundary is found, parse nested multipart\n        if (isset($headers['content-type']) && strpos($headers['content-type'], 'multipart/mixed;boundary=') !== false) {\n            // Extract the sub-boundary from content type header\n            preg_match('/boundary=(.*)/', $headers['content-type'], $matches);\n            $subBoundary = isset($matches[1]) ? trim($matches[1], '"') : null;\n            \n            if ($subBoundary) {\n                // Recursively parse nested multipart\n                $data[] = parseMultipartFormData($subBoundary, $body);\n            }\n        } else {\n            // Save the body as is or process it according to its content-type\n            $data[] = ['headers' => $headers, 'body' => $body];\n        }\n    }\n\n    return $data;\n}\n\n// Get raw POST data\n$rawPostData = file_get_contents('php://input');\n\n// Define the main boundary from the request headers\n$boundary = isset($_SERVER['HTTP_CONTENT_TYPE']) ? substr(strstr($_SERVER['HTTP_CONTENT_TYPE'], 'boundary='), 9) : null;\n\nif ($boundary && $rawPostData !== '') {\n    // Parse the multipart form data\n    $parsedData = parseMultipartFormData($boundary, $rawPostData);\n    \n    // Do something with the parsed data\n    print_r($parsedData);\n} else {\n    echo "Failed to parse request.";\n}\n?>
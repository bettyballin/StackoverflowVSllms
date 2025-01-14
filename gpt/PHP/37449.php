function getBestSupportedContentType(array $supportedTypes) {\n    $acceptHeader = isset($_SERVER['HTTP_ACCEPT']) ? strtolower($_SERVER['HTTP_ACCEPT']) : '';\n    $acceptTypes = explode(',', $acceptHeader);\n    $parsedAcceptTypes = [];\n\n    foreach ($acceptTypes as $acceptType) {\n        $parts = explode(';', $acceptType);\n        $type = trim($parts[0]);\n        $q = 1.0; // Default quality factor\n\n        if (isset($parts[1])) {\n            $qualityParts = explode('=', trim($parts[1]));\n            if (isset($qualityParts[1])) {\n                $q = floatval($qualityParts[1]);\n            }\n        }\n\n        $parsedAcceptTypes[$type] = $q;\n    }\n\n    // Sort the parsed accept types by quality factor in descending order\n    arsort($parsedAcceptTypes);\n\n    // Find the best match from the supported types\n    foreach ($parsedAcceptTypes as $type => $q) {\n        if (in_array($type, $supportedTypes)) {\n            return $type;\n        }\n    }\n\n    // If no match is found, return the default type (first in the supported types list)\n    return $supportedTypes[0];\n}\n\n// Example usage:\n$supportedTypes = ['application/xhtml+xml', 'text/html', 'application/xml', 'text/xml'];\n$bestType = getBestSupportedContentType($supportedTypes);\n\nheader('Content-Type: ' . $bestType);\necho "Content will be served as: " . $bestType;
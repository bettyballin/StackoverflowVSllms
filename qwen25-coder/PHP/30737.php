<?php\nsession_start();\n\n// Function to clean and sanitize domain name\nfunction getDomainFromUrl($url) {\n    $parsed = parse_url($url);\n    return $parsed['host'] ?? '';\n}\n\nif (!empty($_SERVER['HTTP_REFERER'])) {\n    $referrerDomain = getDomainFromUrl($_SERVER['HTTP_REFERER']);\n    \n    // Check if this referrer has already been counted in the session\n    if (!isset($_SESSION['referers'][$referrerDomain])) {\n        // Store the referrer domain in session to mark it as counted\n        $_SESSION['referers'][$referrerDomain] = true;\n        \n        // Insert logic here to increase hits_in count for this domain\n        echo "Counted new hit from: $referrerDomain";\n        \n        // Example: Update database (pseudo code)\n        // incrementHitsIn($referrerDomain);\n    } else {\n        echo "Hit already counted from this session.";\n    }\n} else {\n    echo "No referrer information available.";\n}\n?>
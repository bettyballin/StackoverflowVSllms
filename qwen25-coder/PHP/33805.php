<?php\n$browser = get_browser(null, true);\n$userAgent = $_SERVER['HTTP_USER_AGENT'];\n\nif (strpos($userAgent, 'MSIE') !== false) {\n    $version = '';\n    if (isset($browser['parent'])) {\n        // The parent field often contains the version number in browserscap.ini\n        if (preg_match('/Internet Explorer (\d+)/', $browser['parent'], $matches)) {\n            $version = $matches[1];\n        }\n    }\n\n    if ($version == '7.0') {\n        echo "This is Internet Explorer 7";\n    } elseif ($version == '6.0') {\n        echo "This is Internet Explorer 6";\n    } else {\n        echo "Detected version of IE: " . $version;\n    }\n} else {\n    echo "Not using Internet Explorer.";\n}\n?>
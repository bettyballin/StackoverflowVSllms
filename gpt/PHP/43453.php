<?php\n// Get the protocol (HTTP or HTTPS)\n$protocol = (!empty($_SERVER['HTTPS']) && $_SERVER['HTTPS'] !== 'off' || $_SERVER['SERVER_PORT'] == 443) ? "https://" : "http://";\n\n// Get the host (domain name)\n$host = $_SERVER['HTTP_HOST'];\n\n// Get the requested URI\n$requestUri = $_SERVER['REQUEST_URI'];\n\n// Combine them to get the full URL\n$currentUrl = $protocol . $host . $requestUri;\n\necho $currentUrl;\n?>
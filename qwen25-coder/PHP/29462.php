<?php\n$title = "MySite - Contacts";\n\n// Construct the full URL of the page that included this file\n$fullUrl = (isset($_SERVER['HTTPS']) && $_SERVER['HTTPS'] === 'on' ? "https" : "http") . "://$_SERVER[HTTP_HOST]$_SERVER[REQUEST_URI]";\n\ninclude("header.php");\n\n// You can now use $fullUrl in your template or pass it to header.php if needed\n?>
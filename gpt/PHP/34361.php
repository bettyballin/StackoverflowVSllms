// Check if the request is an AJAX request\n   $isAjax = !empty($_SERVER['HTTP_X_REQUESTED_WITH']) && strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) == 'xmlhttprequest';\n\n   if ($isAjax) {\n       // Include only the main content\n       include 'mainContent.php';\n       exit;\n   } else {\n       // Include the full page with header and footer\n       include 'header.php';\n       include 'mainContent.php';\n       include 'footer.php';\n   }
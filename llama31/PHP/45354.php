if (!empty($_SERVER['HTTP_X_REQUESTED_WITH']) && strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) == 'xmlhttprequest') {\n     // Handle AJAX request\n     $pageContent = // retrieve the page content based on the request URL\n     echo $pageContent;\n   } else {\n     // Handle regular request\n     $hash = $_SERVER['REQUEST_URI'];\n     if (!empty($hash)) {\n       // Retrieve the page content based on the hash\n       $pageContent = // retrieve the page content based on the hash\n       echo $pageContent;\n     } else {\n       // Serve the default page content\n       echo 'Default page content';\n     }\n   }
if (isset($_GET['Format']) && $_GET['Format'] == 'XML') {\n    http_response_code(200);\n    header('Content-Type: application/xml');\n} else {\n    http_response_code(200);\n    header('Content-Type: text/html');\n}
$string = '<script>alert("XSS")</script>';\n   $sanitized_string = filter_var($string, FILTER_SANITIZE_STRING);\n   echo $sanitized_string; // Outputs: alert("XSS")
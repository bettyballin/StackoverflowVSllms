function handleError($message) {\n    // Handle the error, e.g., log the error, send an email, etc.\n    error_log($message);\n    // You can also call another function or method from here\n}\n\nmysql_pconnect("server","tator_w","password") \n    or die(handleError("Unable to connect to SQL server"));
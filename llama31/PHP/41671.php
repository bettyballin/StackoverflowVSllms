try {\n    // Code that might throw an exception\n    if ($error) {\n        throw new Exception('Sorry, error has occurred');\n    }\n} catch (Exception $e) {\n    // Handle the exception\n    echo $e->getMessage();\n}
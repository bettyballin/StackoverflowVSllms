try {\n    $file = fopen($file);\n    if (!$file) {\n        throw new Exception("Unable to retrieve file");\n    }\n} catch (Exception $e) {\n    echo "Error: " . $e->getMessage();\n    // continue execution\n}
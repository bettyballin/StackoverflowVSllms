// Read the file\nif (!($fp = @fopen($fileName, 'rb'))) {\n    $error = error_get_last();\n    if ($error !== null) {\n        $errStr = "Failed to open '{$fileName}' for read. Error: {$error['message']}";\n    } else {\n        $errStr = "Failed to open '{$fileName}' for read. No specific error available.";\n    }\n    break; // try-block\n}
try {\n    // Your import code here\n} catch (Exception $e) {\n    error_log($e->getMessage());\n    echo 'An error occurred during import.';\n}
try {\n    // some code that may throw an exception\n} catch(Exception $e) {\n    echo 'Caught exception: ',  $e->getMessage(), "\n";\n    error_log($e->getMessage() . ' - ' . $e->getTraceAsString());\n}
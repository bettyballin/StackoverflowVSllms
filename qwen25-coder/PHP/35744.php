if ($error) {\n    throw new Exception('Sorry, an error has occurred');\n}\n\ntry {\n    // Your code that may cause an exception\n} catch (Exception $e) {\n    echo 'Caught exception: ',  $e->getMessage(), "\n";\n}
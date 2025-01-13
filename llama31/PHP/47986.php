// Create an object\n$errorHandler = new ErrorHandler();\n\n// Serialize and store the object on disk\n$serializedObject = serialize($errorHandler);\nfile_put_contents('error_handler.cache', $serializedObject);\n\n// Later, retrieve the cached object\n$serializedObject = file_get_contents('error_handler.cache');\n$errorHandler = unserialize($serializedObject);
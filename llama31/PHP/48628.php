// Serializing the data\n$serialized_data = serialize($my_variable);\nfile_put_contents('output.txt', $serialized_data);\n\n// Unserializing the data\n$unserialized_data = file_get_contents('output.txt');\n$variable = unserialize($unserialized_data);\n\nprint_r($variable); // Now $variable holds the original array
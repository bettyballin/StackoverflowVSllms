$myArray = array('key1' => 'value1', 'key2' => 'value2');\n\n// Serialize the array\n$fileContents = serialize($myArray);\n\n// Output the serialized string (for demonstration purposes)\necho $fileContents . "\n";\n\n// Unserialize the string back to an array\n$newArray = unserialize($fileContents);\n\n// Access values from the unserialized array\necho $newArray['key1'] . "\n"; // output: value1\necho $newArray['key2'] . "\n"; // output: value2
function findIndexByUsername($array, $username) {\n    foreach ($array as $index => $element) {\n        if (isset($element['username']) && $element['username'] === $username) {\n            return $index;\n        }\n    }\n    return -1; // Return -1 if the username is not found\n}\n\n// Example usage:\n$array = array(\n    array('username' => 'user1'),\n    array('username' => 'user2')\n);\n\n$usernameToFind = 'user1';\n$index = findIndexByUsername($array, $usernameToFind);\necho $index; // Outputs: 0
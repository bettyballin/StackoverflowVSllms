// Assuming CakePHP 1.x or using Set from Utils plugin in 3.x\n\n$result = false;\nforeach ($usergrouppermissions as $permission) {\n    if (Set::contains($permission, $searchme['UserGroupPermission'])) {\n        $result = true;\n        break; // Exit the loop once a match is found\n    }\n}
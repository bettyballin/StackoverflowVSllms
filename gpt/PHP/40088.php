function storeRegistrationKey($userId, $registrationKey) {\n    $db = JFactory::getDbo();\n    $query = $db->getQuery(true);\n    \n    $columns = array('user_id', 'registration_key');\n    $values = array($db->quote($userId), $db->quote($registrationKey));\n    \n    $query\n        ->insert($db->quoteName('#__registration_keys'))\n        ->columns($db->quoteName($columns))\n        ->values(implode(',', $values));\n    \n    $db->setQuery($query);\n    $db->execute();\n}\n\n// Example usage\nstoreRegistrationKey($userId, $registrationKey);
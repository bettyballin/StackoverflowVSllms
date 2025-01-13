$db = Zend_Db::factory('Mysqli', $dbConfig);\n\n$data = array(\n    'column1' => 'value1',\n    'column2' => 'value2',\n);\n\n$insert = $db->insert('sometable', $data);\n\n$lastInsertId = $db->lastInsertId();\nif (!$lastInsertId) {\n    $updateData = array(\n        'column3' => 'value3',\n        'column4' => 'value4',\n    );\n    $db->update('sometable', $updateData, 'id = ' . $data['id']);\n}
// Example usage of your implementation\n$results = $db->select('id, name')->where('id > 4')->get('users');\n\n//Set them active\nwhile($user = $results->fetch()) {\n    $user->active = TRUE;\n    $user->save();\n}
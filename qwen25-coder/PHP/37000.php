function insert_interests_and_requests($uid, $interests) {\n    global $db;\n    \n    // First, purge any existing entries for this user in both tables\n    purge_lookup("jss_users_interests_table", $uid);\n    purge_lookup("jss_info_requests_table", $uid);\n\n    // Create and execute the SQL insert query for jss_users_interests_table\n    $db->query(create_checkbox_query($interests, "jss_users_interests_table", $uid));\n\n    // Process each interest to find corresponding provider IDs and insert into jss_info_requests_table\n    foreach ($interests as $subcategory_id) {\n        // Fetch the provider_id from jss_providers_assignments_table based on subcategory_id\n        $provider_result = $db->query("SELECT provider_id FROM jss_providers_assignments_table WHERE subcategories_id = '" . $db->escape($subcategory_id) . "'");\n        \n        while ($row = $provider_result->fetch_assoc()) {\n            $provider_id = $row['provider_id'];\n            // Insert into jss_info_requests_table\n            $db->query("INSERT INTO jss_info_requests_table (users_id, provider_id, subcategories_id) VALUES ('" . $db->escape($uid) . "', '" . $db->escape($provider_id) . "', '" . $db->escape($subcategory_id) . "')");\n        }\n    }\n}\n\nfunction purge_lookup($table, $uid) {\n    global $db;\n    $db->query("DELETE FROM $table WHERE users_id = '" . $db->escape($uid) . "'");\n}\n\nfunction create_checkbox_query($arr, $table, $uid) {\n    if (empty($arr)) return ""; // Prevent invalid SQL when no interests are selected\n\n    $q = "INSERT INTO $table (users_id, subcategories_id) VALUES";\n    foreach ($arr as $check) {\n        $q .= " ('" . $db->escape($uid) . "', '" . $db->escape($check) . "'),";\n    }\n    // Remove the last comma and return\n    return substr($q, 0, -1);\n}
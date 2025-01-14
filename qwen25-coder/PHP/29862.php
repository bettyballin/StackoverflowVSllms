function getFilteredData($userId, $pref1, $pref2, ...) {\n    // Fetch JSON data based on user ID\n    $data = get_json_data($userId);\n    \n    $filteredData = $data; // Starting from all data\n\n    if ($pref1 === 1) {\n        $filteredData = applyPreference1Filter($filteredData);\n    }\n    \n    if ($pref2 === 1) {\n        $filteredData = applyPreference2Filter($filteredData);\n    }\n\n    // Add more preference checks here...\n\n    return $filteredData;\n}\n\nfunction applyPreference1Filter($data) {\n    // Logic to filter data based on Preference 1\n    return array_filter($data, function($item) {\n        // Your filtering condition for pref 1\n        return condition_based_on_pref_1($item);\n    });\n}\n\nfunction applyPreference2Filter($data) {\n    // Logic to filter data based on Preference 2\n    return array_filter($data, function($item) {\n        // Your filtering condition for pref 2\n        return condition_based_on_pref_2($item);\n    });\n}\n\n// Fetch all users\n$users = mysqli_query($connection, "SELECT id, pref1, pref2 FROM users");\n\nwhile ($user = mysqli_fetch_assoc($users)) {\n    $filteredData = getFilteredData(\n        $user['id'],\n        $user['pref1'],\n        $user['pref2']\n        // Add other preferences as needed\n    );\n\n    postfinalarray($filteredData);\n}
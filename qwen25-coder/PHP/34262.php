<?php\n\n// Example data\n$friends = [1, 4, 8, 9]; // Imagine these are friendIDs\n$bulletins = [\n    ['bulletinID' => 101, 'userID' => 5],\n    ['bulletinID' => 102, 'userID' => 1],\n    ['bulletinID' => 103, 'userID' => 4],\n    // ... up to 10,000 entries\n];\n\n// Convert $friends array into an associative array for quick lookup\n$friendsAssoc = array_flip($friends);\n\n// Array to store bulletinIDs from friends\n$friendBulletins = [];\n\n// Iterate over each bulletin and check against the friends list\nforeach ($bulletins as $bulletin) {\n    if (isset($friendsAssoc[$bulletin['userID']])) {\n        $friendBulletins[] = $bulletin['bulletinID'];\n        \n        // Limit to first 50 bulletins\n        if (count($friendBulletins) >= 50) {\n            break;\n        }\n    }\n}\n\n// Output the result\nprint_r($friendBulletins);\n\n?>
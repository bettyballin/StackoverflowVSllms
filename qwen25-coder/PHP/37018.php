public static function GetUsersByGroup($instanceID, $groupID)\n{               \n    $col = null;\n    if($groupID !== null) { // Use strict comparison for clarity\n        $col = UserGroup::GetCollection("User", _DB_GET_ALL_INSTANCE_USERGROUP_MEMBERS, array ($instanceID, $groupID));\n        echo "Query executed with groupID: $groupID\n";\n    } else {\n        $col = UserGroup::GetCollection("User", _DB_GET_ALL_INSTANCE_NOGROUP_MEMBERS, $instanceID);\n        echo "Query executed without groupID\n";\n    }\n    \n    // Log the collection to see its state before returning\n    echo "Collection count: " . count($col->getArrayCopy()) . "\n";\n    \n    return $col; \n}
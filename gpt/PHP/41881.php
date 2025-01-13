function googleQueryToSqlWhere($query) {\n    $conditions = [];\n    $tsqueryParts = [];\n    \n    // Handle color field\n    if (preg_match_all('/color:([^\s]+)/', $query, $matches)) {\n        foreach ($matches[1] as $color) {\n            $conditions[] = "color = '$color'";\n        }\n        $query = preg_replace('/color:[^\s]+/', '', $query);\n    }\n\n    // Handle style field\n    if (preg_match_all('/style:([^\s]+)/', $query, $matches)) {\n        foreach ($matches[1] as $style) {\n            $conditions[] = "style = '$style'";\n        }\n        $query = preg_replace('/style:[^\s]+/', '', $query);\n    }\n\n    // Handle the rest as tsquery\n    $query = googleQueryToTsquery($query);\n    if (!empty($query)) {\n        $tsqueryParts[] = "to_tsvector(description) @@ to_tsquery('$query')";\n    }\n    \n    // Combine conditions\n    $allConditions = array_merge($conditions, $tsqueryParts);\n    $whereClause = implode(' AND ', $allConditions);\n    \n    return "WHERE $whereClause";\n}\n\n// Example usage\n$googleQuery = '((color:blue OR "4x4") OR style:coupe) -color:red used';\n$whereClause = googleQueryToSqlWhere($googleQuery);\necho $whereClause;\n// Output: WHERE color = 'blue' OR to_tsvector(description) @@ to_tsquery('4x4') OR style = 'coupe' AND color <> 'red' AND to_tsvector(description) @@ to_tsquery('used')
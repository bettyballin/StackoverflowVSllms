public function select($psTableName, $paFields = "", $paWhere = array())\n{\n    // ...\n\n    if (!empty($paWhere)) {\n        $lsQuery .= "WHERE ";\n        $conditions = array(); // Create a new array to store the conditions\n        foreach ($paWhere as $lsKey => $lsValue) {\n            $conditions[] = $lsKey . " = '" . mysql_real_escape_string($lsValue) . "'";\n        }\n        $lsQuery .= implode(" AND ", $conditions);\n    }\n\n    // ...\n}
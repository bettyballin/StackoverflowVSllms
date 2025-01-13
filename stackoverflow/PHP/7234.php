/*\nSimilar to mysql_fetch_assoc(), this function returns an associative array\ngiven a mysql resource, but prepends the table name (or table alias, if\nused in the query) to the column name, effectively namespacing the column\nnames and allowing SELECTS for column names that would otherwise have collided\nwhen building a row's associative array.\n*/\nfunction mysql_fetch_assoc_with_table_names($resource) {\n    // get a numerically indexed row, which includes all fields, even if their names collide\n    $row = mysql_fetch_row($resource);\n    if( ! $row)\n        return $row;\n\n    $result = array();\n\n    $size = count($row);    \n    for($i = 0; $i < $size; $i++) {\n        // now fetch the field information\n        $info = mysql_fetch_field($resource, $i);\n        $table = $info->table;\n        $name = $info->name;\n        // and make an associative array, where the key is $table.$name\n        $result["$table.$name"] = $row[$i];  // e.g. $result["user.name"] = "Joe Schmoe";\n    }\n\n    return $result;\n}
static function execSQL($query)\n{\n    $db = null;\n    $results = null;\n\n    try {\n        $db = Model::getConnection();\n        $results = mysqli_query($db, $query); // Use mysqli_query instead of a method call on an object\n        if (!$results) {\n            throw new Exception('Query failed', EX_QUERY_FAILED);\n        }\n    } catch (Exception $e) {\n        // errors are handled higher in the object hierarchy\n        Model::closeConnection($db);\n        throw $e;\n    }\n\n    Model::closeConnection($db); // Ensure closure after query execution or exception handling\n\n    return $results;\n}
<?php\nfunction fetch_assoc_with_types($result) {\n    $fields = array();\n    $finfo = mysqli_fetch_fields($result);\n    \n    foreach ($finfo as $val) {\n        $fields[$val->name] = $val->type;\n    }\n\n    $data = array();\n    while ($row = mysqli_fetch_assoc($result)) {\n        foreach ($row as $key => $value) {\n            if ($value === null) {\n                $data[$key] = null;\n                continue;\n            }\n            switch ($fields[$key]) {\n                case MYSQLI_TYPE_TINY:\n                case MYSQLI_TYPE_SHORT:\n                case MYSQLI_TYPE_LONG:\n                case MYSQLI_TYPE_INT24:\n                case MYSQLI_TYPE_LONGLONG:\n                    $data[$key] = (int) $value;\n                    break;\n                case MYSQLI_TYPE_FLOAT:\n                case MYSQLI_TYPE_DOUBLE:\n                case MYSQLI_TYPE_DECIMAL:\n                case MYSQLI_TYPE_NEWDECIMAL:\n                    $data[$key] = (float) $value;\n                    break;\n                case MYSQLI_TYPE_DATE:\n                case MYSQLI_TYPE_DATETIME:\n                case MYSQLI_TYPE_TIMESTAMP:\n                    $data[$key] = new DateTime($value);\n                    break;\n                default:\n                    $data[$key] = $value;\n            }\n        }\n        $resultData[] = $data;\n    }\n\n    return $resultData;\n}\n\n// Usage example:\n$mysqli = new mysqli("localhost", "username", "password", "database");\n\n$result = $mysqli->query("SELECT * FROM your_table");\n$data = fetch_assoc_with_types($result);\n\nvar_dump($data);\n?>
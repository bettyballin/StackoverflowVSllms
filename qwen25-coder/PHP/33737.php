// Connect to SQLite DB\nDB('/path/to/sqlite.db');\n\nDB('BEGIN TRANSACTION;');\n\n$stmt = DB::prepare($query, 'INSERT INTO "test" ("id", "name") VALUES (?, ?);');\n\nfor ($i = 1; $i <= 10000; $i++) {\n    for ($j = 1; $j <= 100; $j++) {\n        DB::execute($stmt, [$i, 'Testing ' . $j]);\n    }\n}\n\nDB('END TRANSACTION;');\n\n// Updated DB function\nfunction DB() {\n    static $db = null;\n\n    if (is_file(func_get_arg(0)) === true) {\n        $db = new PDO('sqlite:' . func_get_arg(0), null, null, array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION));\n    } elseif (func_num_args() == 2 && is_a($db, 'PDO')) {\n        return $db->prepare(func_get_arg(1));\n    } elseif (func_num_args() == 3 && is_a(func_get_arg(0), 'PDOStatement')) {\n        if (func_get_arg(0)->execute(func_get_arg(2)) === true) {\n            if (stripos(func_get_arg(1), 'INSERT') === 0) {\n                return $db->lastInsertId();\n            }\n            if (stripos(func_get_arg(1), 'SELECT') === 0) {\n                return func_get_arg(0)->fetchAll(PDO::FETCH_ASSOC);\n            }\n            return func_get_arg(0)->rowCount();\n        }\n    }\n\n    return false;\n}
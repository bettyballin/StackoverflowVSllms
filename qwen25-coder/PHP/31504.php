<?php\n// db_setup.php\n$db = new PDO('sqlite:users.db');\n$db->exec("CREATE TABLE IF NOT EXISTS users (\n    id INTEGER PRIMARY KEY AUTOINCREMENT,\n    username TEXT UNIQUE NOT NULL,\n    password TEXT NOT NULL\n)");\n?>
$query = '\n    CREATE TABLE IF NOT EXISTS `data` (\n        `id` BIGINT NOT NULL AUTO_INCREMENT UNIQUE,\n        PRIMARY KEY (`id`)\n    )\n    SELECT `field1`, `field2` WHERE `active` = 1\n    UNION\n    SELECT DO_ONE(`field1`), DO_TWO(`field2`) WHERE `active` = 1\n    ORDER BY `field1`\n';\n\n// Use prepared statements to prevent SQL injection\n$stmt = $mysqli->prepare($query);\n$stmt->execute();
string inputValue = "Some 'unsafe' input";\nstring safeInputValue = StringEscaper.EscapeSqlString(inputValue);\n\nstring query = string.Format(\n    "INSERT INTO TABLE_A (COLUMN_A, COLUMN_B) SELECT ('{0}', COLUMN_C) FROM TABLE_B WHERE COLUMN_D = ?",\n    safeInputValue);
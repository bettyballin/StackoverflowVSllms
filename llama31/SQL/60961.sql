SET @sql = NULL;\n\nSELECT\n  GROUP_CONCAT(\n    CONCAT(\n      'DATE_FORMAT(', \n      COLUMN_NAME, \n      ', ''%c/%e/%y'') AS ', \n      COLUMN_NAME\n    )\n    SEPARATOR ', '\n  ) INTO @sql\nFROM\n  information_schema.COLUMNS\nWHERE\n  TABLE_NAME = 'your_table' AND \n  DATA_TYPE = 'timestamp';\n\nSET @sql = CONCAT('SELECT ', @sql, ' FROM your_table');\n\nPREPARE stmt FROM @sql;\nEXECUTE stmt;
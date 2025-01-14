SET @prefix = 'your_prefix_';\nSET @table_names=NULL;\n\nSELECT GROUP_CONCAT(TABLE_NAME) INTO @table_names \nFROM INFORMATION_SCHEMA.TABLES \nWHERE TABLE_TYPE='BASE TABLE'\nAND TABLE_NAME LIKE CONCAT(@prefix, '%')\nAND TABLE_SCHEMA=DATABASE();\n\nIF @table_names IS NOT NULL THEN\n    SET @sql = CONCAT('DROP TABLE ', @table_names);\n    PREPARE stmt FROM @sql;\n    EXECUTE stmt;\n    DEALLOCATE PREPARE stmt;\nEND IF;
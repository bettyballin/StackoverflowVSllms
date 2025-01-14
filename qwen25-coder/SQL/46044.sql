SET @Stmt1 = CONCAT('DROP TABLE IF EXISTS ', DB, '.`county`; ',\n                    'CREATE TABLE IF NOT EXISTS ', DB, '.`County` ',\n                    '(',\n                    '  `CountyID` INT UNSIGNED NOT NULL AUTO_INCREMENT,',\n                    '  `CountyName` VARCHAR(45) NOT NULL,',\n                    '  `CountyCode` VARCHAR(30) NOT NULL,',\n                    '  PRIMARY KEY (`CountyID`)',\n                    ');');\n\nPREPARE stmt2 FROM @stmt1;\nEXECUTE stmt2;\nDEALLOCATE PREPARE stmt2;
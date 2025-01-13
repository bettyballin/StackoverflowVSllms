DELIMITER $$\nCREATE FUNCTION wordcount(str LONGTEXT)\n       RETURNS INT\n       DETERMINISTIC\n       SQL SECURITY INVOKER\n       NO SQL\n  BEGIN\n    DECLARE wordCnt, idx, maxIdx INT DEFAULT 0;\n    DECLARE currChar, prevChar BOOL DEFAULT 0;\n    SET maxIdx=char_length(str);\n    SET idx = 1;\n    WHILE idx <= maxIdx DO\n        SET currChar=SUBSTRING(str, idx, 1) RLIKE '[[:alnum:]]';\n        IF NOT prevChar AND currChar THEN\n            SET wordCnt=wordCnt+1;\n        END IF;\n        SET prevChar=currChar;\n        SET idx=idx+1;\n    END WHILE;\n    RETURN wordCnt;\n  END\n$$\nDELIMITER ;
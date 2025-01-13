DECLARE\n  prmName VARCHAR2(100) := 'John';\n  prmSortField NUMBER := 1;  -- 1 for Name, 2 for Age, etc.\n  CURSOR cur IS\n    SELECT * \n    FROM Names \n    WHERE Name = :prmName \n    ORDER BY CASE\n      WHEN :prmSortField = 1 THEN Name\n      WHEN :prmSortField = 2 THEN Age\n      -- add more cases as needed\n    END;\nBEGIN\n  OPEN cur USING prmName, prmSortField;\n  FETCH cur INTO ...;  -- fetch into your variables\n  CLOSE cur;\nEND;
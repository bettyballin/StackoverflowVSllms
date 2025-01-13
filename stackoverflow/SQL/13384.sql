SELECT  COALESCE (\n        (\n        SELECT  newValue\n        FROM    history\n        WHERE   field = 'Department'\n                AND rowID = ID\n                AND changeDate =\n                (\n                SELECT MAX(changedate)\n                FROM   history\n                WHERE  field = 'Department'\n                       AND rowID = ID\n                       AND changeDate <= '01/01/2009'\n                )\n        ), department)\nFROM    employee\nWHERE   id = @id
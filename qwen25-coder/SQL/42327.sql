SELECT * \nFROM Data \nORDER BY \n    CASE \n        WHEN @Direction = 1 THEN CAST(SortOrder AS VARCHAR) DESC -- For text or non-numeric types\n        ELSE SortOrder \n    END;
SELECT * \nFROM [Translation Color] \nORDER BY \n    CASE \n        WHEN [Language Code] LIKE 'I%' THEN 0 \n        ELSE 1 \n    END, \n    [Language Code]
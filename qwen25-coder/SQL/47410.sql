DECLARE @OrderByColumn VARCHAR(50);\nDECLARE @OrderDirection INT;\n\nSET @OrderByColumn = 'AddedDate';\nSET @OrderDirection = 1; -- 1 for ASC, -1 for DESC\n\nSELECT *\nFROM YourTable\nORDER BY \n    CASE WHEN @OrderDirection = 1 THEN\n        CASE \n            WHEN @OrderByColumn = 'AddedDate' THEN AddedDate\n            WHEN @OrderByColumn = 'Visible' THEN Visible\n            WHEN @OrderByColumn = 'AddedBy' THEN AddedBy\n            WHEN @OrderByColumn = 'Title' THEN Title    \n        END\n    END ASC,\n    CASE WHEN @OrderDirection = -1 THEN\n        CASE \n            WHEN @OrderByColumn = 'AddedDate' THEN AddedDate\n            WHEN @OrderByColumn = 'Visible' THEN Visible\n            WHEN @OrderByColumn = 'AddedBy' THEN AddedBy\n            WHEN @OrderByColumn = 'Title' THEN Title    \n        END\n    END DESC;
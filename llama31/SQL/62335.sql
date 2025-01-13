BEGIN\n    ALTER TABLE SampleTable ADD ColumnThree int\nEND\n\nIF (EXISTS (SELECT * FROM sys.columns WHERE name = 'ColumnThree' AND object_id = OBJECT_ID('SampleTable')))\nBEGIN\n    DECLARE @sql NVARCHAR(100) = 'UPDATE SampleTable SET ColumnThree = 0'\n    EXEC sp_executesql @sql\nEND
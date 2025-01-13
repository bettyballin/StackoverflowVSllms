DECLARE @temp table (\n    ID int IDENTITY(1, 1),\n    data nvarchar(100)\n)\n\nINSERT INTO @temp (data) VALUES ('a,b,c')\nINSERT INTO @temp (data) VALUES ('d,e,f')\n\nSELECT T.ID, S.Item AS dataItem\nFROM @temp AS T\nCROSS APPLY dbo.__StringSplit(T.data, ',') AS S
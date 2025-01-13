declare @x table (tableID int not null primary key identity (1,1), datavalue varchar(10) null)\nINSERT INTO @x values ('one')\nINSERT INTO @x values ('aaaa')\nINSERT INTO @x values ('cccc')\n\ndeclare @y table (tableID int not null primary key               , datavalue varchar(10) null)\n\ndeclare @count int ---------------FROM HERE, see comment\nset @count=5;\nWITH hier(cnt) AS\n        (\n        SELECT  1 AS cnt\n        UNION ALL\n        SELECT  cnt + 1\n        FROM    hier\n        WHERE    cnt < @count\n        ) -----------------------To HERE, see comment\nINSERT INTO @x\n    (datavalue)\n    OUTPUT INSERTED.tableID, INSERTED.datavalue\n    INTO @y\nSELECT\n    'value='+CONVERT(varchar(5),h.cnt)\n    FROM hier  h\n    ORDER BY cnt DESC\n\n\nselect '@x',* from @x  --table you just inserted into\nselect '@y',* from @y  --captured data, including identity
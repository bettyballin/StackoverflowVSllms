declare @checkvar  varchar(10) = 'a';\ndeclare @tempTable TABLE (colx varchar(10));\n\nif @checkvar is null\n    insert into @tempTable (colx)\n    select colx from (values('a'), ('b'), ('c'), ('d')) as tbl(colx);\nelse\n    insert into @tempTable (colx)\n    select colx from (values('a'), ('b'), ('c'), ('d')) as tbl(colx) where colx = @checkvar;\n\n-- Use the table variable as needed\nselect * from @tempTable;
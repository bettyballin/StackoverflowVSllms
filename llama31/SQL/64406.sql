declare @temp table(SomeColumn varchar(50))\ninsert into @temp select 'SomeVal'\nselect * from @temp
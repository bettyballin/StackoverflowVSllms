declare @bitHaveRows bit;\nselect @bitHaveRows = case when count(*) > 0 then 1 else 0 end\n   from table_name\n  where (predicate);
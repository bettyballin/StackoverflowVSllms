select * from (\n    select rank() over (order by tbl1.points desc) rank,\n           tbl1.col1, ..., tbl1.points\n    from table1 tbl1, table2 tbl2\n    where tbl1.tbl2FK = tbl2.PK\n      and tbl2.col1 = someNumber\n      and tbl1.dateColumn = to_date('27-10-2008','dd-mm-yyyy')\n) s\nwhere s.rank <= 3;
create table #nodes (id int primary key)\ninsert into #nodes (id) values (@delete_id)\nwhile @@rowcount > 0\n    insert into #nodes \n    select distinct child.id \n    from table child\n    inner join #nodes parent on child.parentid = parent.id\n    where child.id not in (select id from #nodes)\n\ndelete\nfrom table\nwhere id in (select id from #nodes)
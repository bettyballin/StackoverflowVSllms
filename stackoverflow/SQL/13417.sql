create table temp1 as \n( \n   select\n      sum(1) over( rows unbounded preceding ) insert_num\n     ,col1\n     ,col2\n     ,col3\n   from a join b on a.id=b.id\n) with data ;
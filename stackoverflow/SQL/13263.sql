select t.* from table t\nleft join ( select col1, col2, count(*) as count from table group by col1, col2 ) c on t.col1=c.col1 and t.col2=c.col2\nwhere c.count > 1
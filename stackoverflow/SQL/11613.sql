\n    select * from posts order by date DESC limit 0,1\n    union\n    select * from posts order by date desc limit $start,$end
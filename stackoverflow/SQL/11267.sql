SELECT * from foo where timestamp = (select max(timestamp) from foo)
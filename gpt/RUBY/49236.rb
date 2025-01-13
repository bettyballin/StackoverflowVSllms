# Adjust your query to use IFNULL or NULLIF to handle '0000-00-00 00:00:00'\nquery = <<-SQL\n  SELECT j.n, j.name, j.dsc, j.flag, \n         NULLIF(j.td, '0000-00-00 00:00:00') AS td\n  FROM job j\n  WHERE j.td = '0000-00-00 00:00:00'\nSQL\n\nresults = dbh.select_all(query)
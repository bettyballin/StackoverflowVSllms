results = dbh.select_all("SELECT j.n, j.name, j.dsc, j.flag, j.td FROM job j WHERE j.td = '0000-00-00 00:00:00'")\n\nresults.each do |row|\n  row['td'] = nil if row['td'] == '0000-00-00 00:00:00'\nend
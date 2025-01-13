require 'csv'\n\n# Reading from a file\nCSV.foreach('example.txt', col_sep: "\t") do |row|\n  # process row\nend\n\n# Writing to a file\nCSV.open('example.txt', 'w', col_sep: "\t") do |writer|\n  writer << ['row1', 'row2']\n  # write rows\nend
require 'open-uri'\nrequire 'csv'\n\nurl = 'http://www.testing.com/test.csv'\ncsv_string = open(url).read\n\nrecords = CSV.parse(csv_string, headers: true, header_converters: :symbol)\n\n# Example of iterating over records\nrecords.each do |row|\n  puts row[:your_header_symbol] # Access the column by its symbol\nend
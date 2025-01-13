require 'active_record'\n\n# create a sample dataset\ndata = [\n  { name: 'John', age: 25 },\n  { name: 'Mary', age: 31 },\n  { name: 'David', age: 42 }\n]\n\n# create an in-memory database\nActiveRecord::Base.establish_connection(adapter: 'sqlite3', database: ':memory:')\n\n# perform a query\nresult = data.select { |x| x[:age] > 30 }\nputs result.inspect
require 'sqlite3'\n\ndb = SQLite3::Database.new 'path/to/your/database.sqlite3'\n\nsql = File.read('path/to/export.sqlite3.sql')\ndb.execute_batch(sql)
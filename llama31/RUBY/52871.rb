ActiveRecord::Fixtures.create_fixtures(File.dirname(__FILE__) + "/fixtures", ActiveRecord::Base.connection.tables)
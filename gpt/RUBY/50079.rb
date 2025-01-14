require 'database_cleaner/active_record'\n\nclass ActiveSupport::TestCase\n  # Add more helper methods to be used by all tests here...\n\n  DatabaseCleaner.strategy = :transaction\n\n  setup do\n    DatabaseCleaner.start\n  end\n\n  teardown do\n    DatabaseCleaner.clean\n  end\nend
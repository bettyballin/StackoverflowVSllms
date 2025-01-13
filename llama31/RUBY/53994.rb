require 'sequel/migrations'\n\nSequel.migration do\n  up do\n    create_table :users do\n      primary_key :id\n      String :name\n    end\n  end\n\n  down do\n    drop_table :users\n  end\nend
class Session < ActiveRecord::Base\n     establish_connection(\n       adapter:  'mysql2', # or the appropriate adapter for your database\n       host:     'your_host',\n       username: 'your_username',\n       password: 'your_password',\n       database: 'your_database_name'\n     )\n\n     # If you have a specific table for sessions\n     set_table_name 'sessions'\n   end
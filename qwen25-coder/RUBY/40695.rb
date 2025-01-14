require 'win32ole'\n\ndef append_data_from_source_to_dest(source_db_path, dest_db_path, table_name)\n  # Initialize ADO connection\n  conn = WIN32OLE.new('ADODB.Connection')\n  \n  # Connection strings for source and destination databases\n  source_conn_str = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=#{source_db_path};"\n  dest_conn_str   = "Provider=Microsoft.ACE.OLEDB.12.0;Data Source=#{dest_db_path};"\n\n  # Open both connections\n  conn.Open(source_conn_str)\n  \n  # SQL statement to insert data from source table into destination table\n  sql Statement = "INSERT INTO [#{table_name}] IN \"#{dest_db_path}\" SELECT * FROM [#{table_name}];"\n  \n  begin\n    conn.Execute(sql_statement)\n  rescue => e\n    puts "Error occurred: #{e.message}"\n  ensure\n    # Close the connection to the source database\n    conn.Close unless conn.state == 0\n  end\nend\n\n# Example usage for a single table in a given database\nsource_db_path = 'C:\path\to\your\source_database.accdb'\ndest_db_path   = 'C:\path\to\your\destination_database.accdb'\ntable_name     = 'YourTableName'\n\nappend_data_from_source_to_dest(source_db_path, dest_db_path, table_name)
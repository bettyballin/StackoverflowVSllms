SELECT \n  index_name, \n  table_name, \n  num_rows, \n  last_analyzed, \n  buffer_busy_wait\nFROM \n  dba_indexes \nWHERE \n  table_owner = 'YOUR_SCHEMA';
SELECT index_name, index_type, clustering_factor\nFROM dba_indexes\nWHERE table_name = 'your_table_name';
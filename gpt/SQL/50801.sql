SELECT \n    mt.id,\n    mt.field1,\n    mt.field2,\n    mt.field3,\n    bt.blob_data\nFROM \n    MainTable mt\nLEFT JOIN \n    BlobTable bt\nON \n    mt.id = bt.main_table_id\nWHERE \n    mt.id = ?
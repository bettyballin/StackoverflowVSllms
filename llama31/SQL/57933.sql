-- On DB1\nDECLARE\n  v_file BFILE;\nBEGIN\n  v_file := BFILENAME('DIRECTORY', 'filename.dat');\n  DBMS_FILE_TRANSFER.PUT_FILE(\n    source_directory_object => 'DIRECTORY',\n    source_file_name        => 'filename.dat',\n    destination_directory_object => 'DIRECTORY',\n    destination_file_name        => 'filename.dat',\n    destination_database        => 'DB2'\n  );\nEND;\n\n-- On DB2\nDECLARE\n  v_file BFILE;\nBEGIN\n  v_file := BFILENAME('DIRECTORY', 'filename.dat');\n  DBMS_FILE_TRANSFER.GET_FILE(\n    source_directory_object => 'DIRECTORY',\n    source_file_name        => 'filename.dat',\n    destination_directory_object => 'DIRECTORY',\n    destination_file_name        => 'filename.dat'\n  );\nEND;
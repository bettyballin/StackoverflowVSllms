run {\n     allocate channel c1 device type disk;\n     backup database format '/path/to/backup/db_%U.bkp';\n     release channel c1;\n   }
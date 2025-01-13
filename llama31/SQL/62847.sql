CREATE TABLE external_table (\n  field1 VARCHAR2(10),\n  field2 VARCHAR2(10)\n)\nORGANIZATION EXTERNAL (\n  TYPE ORACLE_LOADER\n  DEFAULT DIRECTORY my_dir\n  ACCESS PARAMETERS (\n    RECORDS DELIMITED BY NEWLINE\n    MULTIPLE RECORDS (\n      RECORD TYPE 'TYPE1' (\n        field1 POSITION(10:18),\n        field2 POSITION(26:35)\n      ),\n      RECORD TYPE 'TYPE2' (\n        field1 POSITION(23:27),\n        field2 POSITION(15:19)\n      )\n    )\n  )\n  LOCATION ('my_file.txt')\n);
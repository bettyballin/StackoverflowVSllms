CREATE TABLE inventory_master (\n       part_number VARCHAR(30) PRIMARY KEY,\n       type CHAR(1)\n   );\n\n   CREATE TABLE import_table (\n       part_number VARCHAR(30),\n       quantity INT\n   );
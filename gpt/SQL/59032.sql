CREATE TABLE my_table (\n    id NUMBER DEFAULT my_sequence.NEXTVAL PRIMARY KEY,\n    other_column VARCHAR2(100)\n);
-- First, create the object type for the key-value pair\nCREATE OR REPLACE TYPE TMap;\n\nCREATE OR REPLACE TYPE TKey AS OBJECT (\n    name VARCHAR2(240),\n    value_text VARCHAR2(2000),\n    value_map TMap -- This makes it mutually recursive\n);\n\n-- Then, create the nested table type for the map\nCREATE OR REPLACE TYPE TMap AS TABLE OF TKey;\n/
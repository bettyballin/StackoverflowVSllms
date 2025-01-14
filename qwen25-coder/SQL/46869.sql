-- Disable constraints temporarily\nALTER TABLE your_table DISABLE CONSTRAINT your_constraint;\n\n-- Perform direct path load using APPEND hint for insert statements\nINSERT /*+ APPEND */ INTO your_table (column1, column2)\nSELECT column1, column2 FROM source_table;\n\n-- Re-enable constraints after loading\nALTER TABLE your_table ENABLE NOVALIDATE CONSTRAINT your_constraint;
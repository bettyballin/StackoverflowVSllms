WITH subquery AS (\n  SELECT \n    (...) \n    DECODE(upper(Table.Column), 'SOMETHING', '---', TABLE2.COLUMN2) as VALUE\n    (...)\n)\nSELECT * FROM subquery\nWHERE upper(VALUE) like 'SOMETHING'
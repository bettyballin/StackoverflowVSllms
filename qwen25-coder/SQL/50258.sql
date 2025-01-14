SELECT \n    Key,\n    MAX(CASE WHEN Col = 'Foo' THEN Col END) AS Result\nFROM \n    your_table_name\nGROUP BY \n    Key\nHAVING \n    MAX(CASE WHEN Col = 'Foo' THEN Col END) IS NOT NULL\nUNION ALL\nSELECT \n    Key,\n    Col AS Result\nFROM \n    your_table_name\nWHERE \n    Col = 'Bar'\n    AND Key NOT IN (SELECT Key FROM your_table_name WHERE Col = 'Foo');
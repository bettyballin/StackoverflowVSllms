SELECT \n    MIN(VALUE) AS RangeLow,\n    MAX(VALUE) AS RangeHigh,\n    AVG(VALUE) AS AverageValue\nFROM \n    your_table_name;
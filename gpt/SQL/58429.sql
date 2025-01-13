MERGE MyTable AS target\nUSING (VALUES ('key_value', 'data1_value', 'data2_value')) AS source (KEY, datafield1, datafield2)\nON (target.KEY = source.KEY)\nWHEN MATCHED THEN\n    UPDATE SET\n        target.datafield1 = source.datafield1,\n        target.datafield2 = source.datafield2\nWHEN NOT MATCHED THEN\n    INSERT (KEY, datafield1, datafield2)\n    VALUES (source.KEY, source.datafield1, source.datafield2);
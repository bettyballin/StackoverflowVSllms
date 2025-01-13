-- Sample tables and data\nCREATE TABLE objects (\n    object_id INT PRIMARY KEY,\n    object_name VARCHAR(255)\n);\n\nCREATE TABLE objects_tags (\n    object_id INT,\n    tag VARCHAR(255)\n);\n\nINSERT INTO objects VALUES (1, 'apple'), (2, 'banana'), (3, 'cheese'), (4, 'firetruck');\nINSERT INTO objects_tags VALUES \n    (1, 'fruit'), (1, 'red'), (1, 'food'),\n    (2, 'fruit'), (2, 'yellow'), (2, 'food'),\n    (3, 'yellow'), (3, 'food'),\n    (4, 'vehicle'), (4, 'red');\n\n-- Query to find objects that match all given tags\nSELECT o.object_name\nFROM objects o\nJOIN objects_tags ot ON o.object_id = ot.object_id\nWHERE ot.tag IN ('fruit', 'food')\nGROUP BY o.object_id, o.object_name\nHAVING COUNT(DISTINCT ot.tag) = 2;
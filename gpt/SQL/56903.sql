CREATE PARTITION FUNCTION MyPartitionFunction (int)\n   AS RANGE LEFT FOR VALUES (1000, 2000, 3000); -- Define ranges as needed
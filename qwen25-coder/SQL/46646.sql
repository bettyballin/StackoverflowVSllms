-- Assuming we have a RANGE RIGHT partition function on a date column\nALTER PARTITION SCHEME MyPartitionScheme NEXT USED (N'PRIMARY');\nALTER PARTITION FUNCTION MyRangePF() SPLIT RANGE ('2024-01-01');
BEGIN\n    DBMS_Stats.gather_table_stats(null, 'PARTITIONED_TABLE', \n        partname => 'PARTITION_NAME', granularity => 'PARTITION');\nEND;
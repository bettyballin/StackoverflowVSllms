DBMS_STATS.GATHER_TABLE_STATS(\n      ownname   => 'schema_name',\n      tabname   => 'partitioned_table_name',\n      partname  => 'partition_name',\n      granularity => 'GLOBAL AND PARTITION'\n    );
CREATE TABLE your_table (\n        ID NUMBER,\n        ...\n    )\n    PARTITION BY RANGE (ID) (\n        PARTITION p1 VALUES LESS THAN (1000),\n        PARTITION p2 VALUES LESS THAN (2000),\n        ...\n    );
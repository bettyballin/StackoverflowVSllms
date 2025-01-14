CREATE PARTITION FUNCTION pf_LogDate (DATE)\n   AS RANGE RIGHT FOR VALUES ('2017-01-01', '2018-01-01');\n\n   CREATE PARTITION SCHEME ps_LogDate\n   AS PARTITION pf_LogDate TO (Filegroup1, Filegroup2, Filegroup3);
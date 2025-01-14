CREATE VIEW Table2_with_endtime AS\nSELECT \n  Id,\n  StartTime,\n  Duration,\n  StartTime + Duration/24 AS EndTime\nFROM \n  Table2;\n\nCREATE INDEX idx_table2_with_endtime ON Table2_with_endtime (StartTime, EndTime);
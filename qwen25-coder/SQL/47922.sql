-- Create the archive table\nCREATE TABLE MetricsData_Archive (\n    ID int NOT NULL,\n    MeasurementDate datetime NOT NULL,\n    MetricValue float NOT NULL,\n    PRIMARY KEY (ID, MeasurementDate)\n);\n\n-- Create the roll-up table for aggregated data\nCREATE TABLE MetricsData_Rollup (\n    ID int NOT NULL,\n    YearMonth char(6) NOT NULL,\n    AverageMetricValue float NOT NULL,\n    CountOfRecords int NOT NULL,\n    PRIMARY KEY (ID, YearMonth)\n);\n\n-- Move old data to the archive\nINSERT INTO MetricsData_Archive (ID, MeasurementDate, MetricValue)\nSELECT ID, MeasurementDate, MetricValue\nFROM MetricsData\nWHERE MeasurementDate < DATEADD(YEAR, -2, GETDATE());\n\nDELETE FROM MetricsData\nWHERE MeasurementDate < DATEADD(YEAR, -2, GETDATE());\n\n-- Aggregate the archived data into roll-up table\nINSERT INTO MetricsData_Rollup (ID, YearMonth, AverageMetricValue, CountOfRecords)\nSELECT \n    ID,\n    CONVERT(char(6), MeasurementDate, 112) AS YearMonth,\n    AVG(MetricValue) AS AverageMetricValue,\n    COUNT(ID) AS CountOfRecords\nFROM MetricsData_Archive\nGROUP BY ID, CONVERT(char(6), MeasurementDate, 112);
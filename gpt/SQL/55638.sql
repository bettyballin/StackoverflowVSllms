SELECT\n    SUM(LEN(RequestedReportParams) - LEN(REPLACE(RequestedReportParams, ',', ''))) AS comma_count\nFROM\n    [table]\nWHERE\n    RequestedReportParams LIKE '%,%'
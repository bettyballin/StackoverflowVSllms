-- Create a composite non-clustered index\nCREATE NONCLUSTERED INDEX idx_usagelog_date_userid \nON UsageLog (Date, UserID);\n\n-- Optimized query using CTE\nWITH FilteredUsageLog AS (\n    SELECT UserID, Date\n    FROM UsageLog\n    WHERE Date BETWEEN 200901 AND 200902\n)\nSELECT Date, COUNT(DISTINCT UserID) AS DistinctUserCount\nFROM FilteredUsageLog\nGROUP BY Date;
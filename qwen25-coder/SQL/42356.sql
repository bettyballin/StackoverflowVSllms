-- Convert to specific string format using CONVERT and style parameter\nSELECT CONVERT(VARCHAR, GETDATE(), 101) AS FormattedDate;  -- Output: mm/dd/yyyy
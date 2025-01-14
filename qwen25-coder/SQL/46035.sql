CREATE PROCEDURE UpdateCustomerDiscUsageCalculations\nAS\nBEGIN\n    -- Temporary table to hold intermediate results if needed\n    DECLARE @TempResults TABLE (\n        CustomerID INT,\n        TotalDiscUsage BIGINT, -- assumes total disc usage is within the int range; adjust if necessary\n        CalculatedY FLOAT\n    );\n\n    -- Perform calculations and store in a temporary table\n    INSERT INTO @TempResults (CustomerID, TotalDiscUsage, CalculatedY)\n    SELECT \n        c.CustomerID,\n        SUM(s.DiscUsageMB) AS TotalDiscUsage,\n        ((COUNT(u.UserID) * 200.0) - SUM(s.DiscUsageMB)) / (10 * 5) AS CalculatedY\n    FROM \n        Customers c\n    INNER JOIN \n        Users u ON c.CustomerID = u.CustomerID\n    INNER JOIN \n        Storage s ON u.UserID = s.UserID\n    GROUP BY \n        c.CustomerID;\n\n    -- Update the original table with calculated Y values\n    UPDATE cu\n    SET yValue = tr.CalculatedY\n    FROM \n        CustomerUsageValues cu\n    INNER JOIN \n        @TempResults tr ON cu.CustomerID = tr.CustomerID;\nEND;
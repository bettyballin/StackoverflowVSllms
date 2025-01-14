CREATE PROCEDURE GetTenantData\nAS\nBEGIN\n    -- Create a temporary table to hold tenant status ID\n    DECLARE @TenantStatusID TABLE (ID INT)\n\n    INSERT INTO @TenantStatusID (ID)\n    SELECT ID FROM tblTenantStatus WHERE Description = 'Current'\n\n    -- Select the combined data\n    SELECT \n        t.TenantID,\n        ta.TenantBalance,\n        ts.ID AS TenantStatusID\n    FROM \n        @TenantStatusID ts\n    INNER JOIN \n        tblTransaction t ON ts.ID = t.StatusID\n    OUTER APPLY\n    (\n        SELECT SUM(tblT.AmountPaid) - SUM(tblT.AmountCharged) AS TenantBalance, tblT.TenantID\n        FROM tblTransaction tblT\n        WHERE tblT.TenantID = t.TenantID\n        GROUP BY tblT.TenantID\n    ) ta\nEND
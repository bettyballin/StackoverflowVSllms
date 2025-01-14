DECLARE @CurrentRow INT = 1;\nDECLARE @TotalRows INT;\n\n-- Temp table or CTE to hold the data with row numbers and calculated currWorker values\nWITH updatedValues AS (\n    SELECT \n        t.loanid,\n        ROW_NUMBER() OVER (ORDER BY t.loanid) AS RowNumber,\n        CASE \n            WHEN t.currstatus IN ('R_UW_Approved','R_Submitted to Underwriting') THEN u.UserLogonName\n            WHEN t.currstatus IN ('R_UW Approved With Conditions','R_Loan Resubmitted','R_UW_Suspended','R_Submitted to Processing') THEN procUser.UserLogonName\n            WHEN t.currstatus IN ('R_Docs Out','R_Ready to Close','R_Scheduled to Close and Fund','Scheduled To Close') THEN closeUser.UserLogonName\n        END AS NewCurrWorker\n    FROM #table t\n    LEFT JOIN tblLoanInvolvement li ON li.LOANid = t.loanid\n    LEFT JOIN tblUser u ON u.userID = li.invlUnderwriterDeptID\n    LEFT JOIN tblUser procUser ON procUser.userID = li.invlProcessorID\n    LEFT JOIN tblUser closeUser ON closeUser.userID = li.invlCloserID\n)\n-- Get the total number of rows to update\nSELECT @TotalRows = COUNT(*) FROM updatedValues;\n\nWHILE @CurrentRow <= @TotalRows\nBEGIN\n    BEGIN TRY\n        -- Update a single row based on RowNumber\n        UPDATE #table\n        SET currWorker = uv.NewCurrWorker\n        FROM #table t\n        INNER JOIN updatedValues uv ON t.loanid = uv.loanid AND uv.RowNumber = @CurrentRow;\n        \n        -- Move to the next row\n        SET @CurrentRow = @CurrentRow + 1;\n    END TRY\n    BEGIN CATCH\n        -- Log error details including loanid\n        INSERT INTO ErrorLog (LoanID, ErrorMessage)\n        VALUES (\n            (SELECT loanid FROM updatedValues WHERE RowNumber = @CurrentRow),\n            ERROR_MESSAGE()\n        );\n        \n        -- Exit loop on error to prevent further updates\n        BREAK;\n    END CATCH\nEND;
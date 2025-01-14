-- Save the current date format\nDECLARE @originalDateformat VARCHAR(3)\n\n-- Use a query to get the current date in ODBC canonical form (which uses 'YMD') and compare with known formats\nIF CAST(GETDATE() AS CHAR(10)) = CONVERT(VARCHAR(10), GETDATE(), 120)\n BEGIN \n    SET @originalDateformat = 'Ymd'\n END\nELSE IF CAST(GETDATE() AS CHAR(10)) = CONVERT(VARCHAR(10), GETDATE(), 103)\n BEGIN \n    SET @originalDateformat = 'Dmy'\n END\nELSE IF CAST(GETDATE() AS CHAR(10)) = CONVERT(VARCHAR(10), GETDATE(), 101)\n BEGIN \n    SET @originalDateformat = 'Mdy'\n END\nELSE \n BEGIN \n    -- Default to Mdy if unknown format\n    SET @originalDateformat = 'Mdy'\n END\n\n-- Set the new date format (e.g., 'Ymd' for year-month-day)\nSET DATEFORMAT ymd;\n\nBEGIN TRY\n    -- Your INSERT statements here\n    PRINT 'Inserting data with temporarily set date format';\n    -- Example:\n    -- INSERT INTO MyTable (MyDateColumn) VALUES ('2023-11-15');\n    \nEND TRY\nBEGIN CATCH\n    PRINT ERROR_MESSAGE();\nEND CATCH\n\n-- Reset the original date format\nSET DATEFORMAT @originalDateformat;
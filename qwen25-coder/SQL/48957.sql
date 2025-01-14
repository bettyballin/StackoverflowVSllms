-- Assume initial setup (first time)\nCREATE SYNONYM dbo.IpCountries FOR dbo.IpToCountry;\nGO\n\nBEGIN TRANSACTION;\n\n    -- Rename existing table with a timestamp or unique identifier if needed for backup/reference\n    EXEC sp_rename 'dbo.IpToCountry', 'IpToCountryOld';\n    \n    -- Rename new table to current table name\n    EXEC sp_rename 'dbo.IpToCountryNew', 'IpToCountry';\n\n    -- Modify synonym to point to the newly imported table\n    DROP SYNONYM dbo.IpCountries;\n    CREATE SYNONYM dbo.IpCountries FOR dbo.IpToCountry;\n\nCOMMIT TRANSACTION;
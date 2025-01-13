DECLARE @LicenseLimit INT = 10;\nDECLARE @CheckDateTime DATETIME = '2022-01-01 12:00:00';\n\nSELECT COUNT(*) AS ActiveUsers\nFROM LoginHistory\nWHERE LoginDateTime <= @CheckDateTime AND (LogoutDateTime IS NULL OR LogoutDateTime > @CheckDateTime);
BEGIN TRANSACTION;\n\n-- Acquire an application lock to ensure exclusive access\nEXEC sp_getapplock @Resource = 'IpToCountrySwap', @LockMode = 'Exclusive';\n\n-- Rename the existing table\nEXEC sp_rename 'IpToCountry', 'IpToCountryOld';\n\n-- Rename the new table\nEXEC sp_rename 'IpToCountryNew', 'IpToCountry';\n\n-- Release the application lock\nEXEC sp_releaseapplock @Resource = 'IpToCountrySwap';\n\nCOMMIT TRANSACTION;
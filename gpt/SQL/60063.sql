SELECT [Phone]\nFROM [Table]\nWHERE\n(\n    [Phone] LIKE '%[A-Za-z]%'  -- This will match any phone number containing alphabetic characters\n    OR [Phone] = 'N/A'\n    OR [Phone] LIKE '0'        -- This will match phone numbers that are exactly '0'\n    OR [Phone] LIKE '0%' AND [Phone] NOT LIKE '%[^0]%'  -- This will match phone numbers that are all zeros\n)
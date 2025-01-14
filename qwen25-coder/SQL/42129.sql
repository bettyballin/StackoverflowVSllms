BEGIN TRANSACTION;\n\n-- Step 1: Create a new non-identity column\nALTER TABLE YourTableName ADD new_ID INT NOT NULL DEFAULT (0);\n\n-- Step 2: Update the new_ID with ID + 1\nUPDATE YourTableName SET new_ID = ID + 1;\n\n-- Step 3: Drop the old column\nEXEC sp_rename 'YourTableName.ID', 'oldID', 'COLUMN';\n\n-- Step 4: Rename the new column to the original name of the dropped column\nEXEC sp_rename 'YourTableName.new_ID', 'ID', 'COLUMN';\n\n-- Step 5: Add identity specification\nALTER TABLE YourTableName ADD CONSTRAINT PK_YourTableName PRIMARY KEY CLUSTERED (ID) -- If needed\nDBCC CHECKIDENT ('YourTableName', RESEED, MAX); -- Reseed the ID to the max value from old data\n\nCOMMIT TRANSACTION;
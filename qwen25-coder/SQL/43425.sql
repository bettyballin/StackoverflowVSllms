-- Step 1: Insert new contacts and capture their IDs\nDECLARE @InsertedContacts TABLE (UserID INT, ContactID INT);\n\nINSERT INTO Contacts (UserID, FirstName, LastName, EmailAddress)\nOUTPUT INSERTED.UserID, INSERTED.ID INTO @InsertedContacts(UserID, ContactID)\nSELECT DISTINCT s.UserID, s.FirstName, s.LastName, s.EmailAddress\nFROM ContactImportStaging s\nWHERE NOT EXISTS (\n    SELECT 1 \n    FROM Contacts c \n    WHERE c.UserID = s.UserID AND c.EmailAddress = s.EmailAddress AND c.FirstName = s.FirstName AND c.LastName = s.LastName\n);\n\n-- Step 2: Insert into ContactGroupMapping using the captured IDs\nINSERT INTO ContactGroupMapping (ContactID, GroupID)\nSELECT ic.ContactID, s.GroupID\nFROM @InsertedContacts ic\nJOIN ContactImportStaging s ON ic.UserID = s.UserID;
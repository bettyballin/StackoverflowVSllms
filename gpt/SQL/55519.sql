CREATE PROCEDURE InsertContacts\n    @ID INT,\n    @ContactName1 NVARCHAR(50),\n    @Designation1 NVARCHAR(50),\n    @ContactName2 NVARCHAR(50),\n    @Designation2 NVARCHAR(50)\nAS\nBEGIN\n    INSERT INTO YourTableName (ID, ContactName, Designation)\n    VALUES\n        (@ID, @ContactName1, @Designation1),\n        (@ID, @ContactName2, @Designation2);\nEND
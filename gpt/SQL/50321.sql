CREATE PROCEDURE AddFakeColumnWithNewID\nAS\nBEGIN\n    SET NOCOUNT ON;\n    \n    -- Your original query\n    SELECT \n        *, \n        NEWID() AS FakeUniqueIdentifier\n    FROM \n        YourTable;\nEND;\nGO
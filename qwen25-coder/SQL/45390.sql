CREATE TRIGGER trg_ForUpdateOnBookIssuedDetails\nON BOOKISSUEDDETAILS\nFOR UPDATE\nAS\nBEGIN\n    DECLARE @Rows1 INT, @Rows2 INT\n\n    -- Check if the ReturnedOn column was updated\n    IF UPDATE(ReturnedOn)\n    BEGIN\n        -- Ensure there are new rows in the INSERTED table (indicating updates)\n        IF EXISTS(SELECT 1 FROM INSERTED)\n        BEGIN\n            UPDATE nur\n            SET nur.NumberOfBooksIssued = nur.NumberOfBooksIssued - 1\n            FROM NewUserRegister nur \n            INNER JOIN INSERTED i ON i.IssuedTo = nur.UserName\n\n            SET @Rows1 = @@RowCount\n\n            UPDATE lbd \n            SET Inventory = Inventory + 1\n            FROM LIBRARYBOOKDETAILS lbd \n            INNER JOIN inserted i ON lbd.BookID = i.BookId\n\n            SET @Rows2 = @@ROWCOUNT\n\n            IF @Rows1 * @Rows2 > 0\n                COMMIT TRAN;\n            ELSE\n            BEGIN\n                RAISERROR('Error Updating the Database', 16, -1);\n                ROLLBACK TRAN;\n            END\n        END\n    END\nEND;
CREATE PROCEDURE Add_Account\n    @username NVARCHAR(50),\n    @accountDetails NVARCHAR(MAX)\nAS\nBEGIN\n    IF NOT EXISTS (SELECT 1 FROM user_roles WHERE username = @username AND role = 'manager')\n    BEGIN\n        THROW 50001, 'User does not have permission to add accounts.', 1;\n    END\n\n    -- Proceed to add the account\n    INSERT INTO accounts (username, account_details)\n    VALUES (@username, @accountDetails);\nEND
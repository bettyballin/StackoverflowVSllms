CREATE PROCEDURE UpdateMultipleTables\n    @new_value NVARCHAR(255),\n    @table1_id INT,\n    @table2_id INT,\n    @table3_id INT\nAS\nBEGIN\n    BEGIN TRY\n        BEGIN TRANSACTION;\n\n        -- Update Table1\n        UPDATE Table1\n        SET field1 = @new_value\n        WHERE id = @table1_id;\n\n        -- Update Table2\n        UPDATE Table2\n        SET field2 = @new_value\n        WHERE id = @table2_id;\n\n        -- Update Table3\n        UPDATE Table3\n        SET field3 = @new_value\n        WHERE id = @table3_id;\n\n        COMMIT TRANSACTION;\n    END TRY\n    BEGIN CATCH\n        ROLLBACK TRANSACTION;\n        -- Handle the error, e.g., log it or rethrow\n        THROW;\n    END CATCH\nEND
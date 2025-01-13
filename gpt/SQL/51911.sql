BEGIN TRANSACTION\n\nBEGIN TRY\n    INSERT INTO dbo.ITSUsage (\n        Customer_ID,\n        [Type],\n        Source\n    ) VALUES ( \n        @Customer_ID,\n        @Type,\n        @Source\n    );\n\n    SET @ID = SCOPE_IDENTITY();  \n\n    IF @Type = 1\n    BEGIN\n        EXEC usp_Type1_INS @ID, @UsageInfo;\n    END\n    ELSE IF @Type = 2\n    BEGIN\n        EXEC usp_Type2_INS @ID, @UsageInfo;\n    END\n\n    COMMIT TRANSACTION;\nEND TRY\nBEGIN CATCH\n    ROLLBACK TRANSACTION;\n    -- Handle the error (e.g., log it, rethrow it, etc.)\n    DECLARE @ErrorMessage NVARCHAR(4000) = ERROR_MESSAGE();\n    RAISERROR(@ErrorMessage, 16, 1);\nEND CATCH;
BEGIN TRAN OuterTransaction;\n    -- First level of transaction\n    INSERT INTO MyTable (Column1) VALUES ('Value1');\n    \n    BEGIN TRAN InnerTransaction;\n        -- Nested transaction\n        INSERT INTO MyTable (Column1) VALUES ('Value2');\n        \n        -- Commit or rollback the nested transaction\n        IF @@ERROR = 0 \n        BEGIN\n            COMMIT TRAN InnerTransaction;\n        END\n        ELSE\n        BEGIN\n            ROLLBACK TRAN InnerTransaction;\n        END\n    -- End of nested transaction\n    \n    -- Commit or rollback the outer transaction\n    IF @@ERROR = 0 \n    BEGIN\n        COMMIT TRAN OuterTransaction;\n    END\n    ELSE\n    BEGIN\n        ROLLBACK TRAN OuterTransaction;\n    END\n-- End of outer transactio
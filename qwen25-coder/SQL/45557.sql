DO $$\nBEGIN\n    -- Start a transaction\n    BEGIN;\n        -- Insert movement\n        INSERT INTO movements (from, to, import) VALUES ('mary', 'steve', 600);\n        \n        -- Update credits\n        UPDATE users SET credit = credit - 600 WHERE name = 'mary';\n        UPDATE users SET credit = credit + 600 WHERE name = 'steve';\n\n        -- Check if mary's credit is less than 0 and rollback if true\n        IF (SELECT credit FROM users WHERE name = 'mary') < 0 THEN\n            ROLLBACK;\n        ELSE\n            COMMIT;\n        END IF;\n\n    EXCEPTION\n        -- Rollback in case of any errors\n        WHEN OTHERS THEN\n            ROLLBACK;\n            RAISE;\n    END;\nEND $$;
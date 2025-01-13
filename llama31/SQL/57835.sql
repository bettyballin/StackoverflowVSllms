BEGIN;\n    INSERT INTO movements (from, to, import) VALUES ('mary', 'steve', 600);\n    UPDATE users SET credit = credit - 600 WHERE name = 'mary';\n    UPDATE users SET credit = credit + 600 WHERE name = 'steve';\n\n    DO $$\n    BEGIN\n        IF (SELECT credit FROM users WHERE name = 'mary') < 0 THEN\n            RAISE EXCEPTION 'Insufficient credit';\n        END IF;\n    END $$;\n\n    COMMIT;\nEXCEPTION\n    WHEN OTHERS THEN\n        ROLLBACK;\n        RAISE NOTICE 'Transaction rolled back';
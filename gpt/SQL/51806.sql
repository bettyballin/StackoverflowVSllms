CREATE OR REPLACE TRIGGER enforce_single_child\nBEFORE INSERT OR UPDATE ON SAMPLE\nFOR EACH ROW\nDECLARE\n    child_count INTEGER;\nBEGIN\n    SELECT COUNT(*) INTO child_count\n    FROM child_table1 ct1\n    WHERE ct1.sample_id = :NEW.sample_id\n    UNION ALL\n    SELECT COUNT(*) FROM child_table2 ct2 WHERE ct2.sample_id = :NEW.sample_id;\n    -- Add similar SELECT statements for all child tables\n\n    IF child_count > 1 THEN\n        RAISE_APPLICATION_ERROR(-20001, 'A SAMPLE entry can only have one child.');\n    END IF;\nEND;\n/
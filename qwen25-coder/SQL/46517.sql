CREATE OR REPLACE TRIGGER trg_check_sample_child_integrity\nBEFORE INSERT OR UPDATE ON SAMPLE\nFOR EACH ROW\nDECLARE\n  v_count NUMBER;\nBEGIN\n  -- Check if there is exactly one child entry in any concrete table\n  SELECT COUNT(*)\n  INTO v_count\n  FROM (\n    SELECT 1 FROM CONCRETE_TABLE_1 WHERE sample_id = :NEW.sample_id\n    UNION ALL\n    SELECT 1 FROM CONCRETE_TABLE_2 WHERE sample_id = :NEW.sample_id\n    -- Add more tables as needed\n  );\n\n  IF v_count <> 1 THEN\n    RAISE_APPLICATION_ERROR(-20001, 'SAMPLE entry must have exactly one child entry in any concrete table.');\n  END IF;\nEND;\n/
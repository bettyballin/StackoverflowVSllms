CREATE TRIGGER trg_FactTable_CascadeDelete\nON FactTable\nINSTEAD OF DELETE\nAS\nBEGIN\n    DELETE FROM FactTable\n    WHERE source_id IN (SELECT id FROM deleted)\n\n    DELETE FROM FactTable\n    WHERE target_id IN (SELECT id FROM deleted)\nEND\nGO\n\nCREATE TRIGGER trg_FactTable_CascadeUpdate\nON FactTable\nINSTEAD OF UPDATE\nAS\nBEGIN\n    UPDATE f\n    SET f.source_id = i.id\n    FROM FactTable f\n    INNER JOIN inserted i ON f.source_id = i.id\n\n    UPDATE f\n    SET f.target_id = i.id\n    FROM FactTable f\n    INNER JOIN inserted i ON f.target_id = i.id\nEND\nGO
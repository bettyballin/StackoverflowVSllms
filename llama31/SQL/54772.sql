BEGIN TRANSACTION;\n\nUPDATE tbl\nSET owner = NEW.uuid, status = 'in_progress'\nWHERE available AND owner IS NULL LIMIT 1;\n\nSELECT stuff\nFROM tbl\nWHERE owner = NEW.uuid;\n\nCOMMIT;
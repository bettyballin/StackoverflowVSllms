BEGIN TRANSACTION outer_tran\n    BEGIN TRANSACTION inner_tran\n        INSERT INTO table1 (column1) VALUES ('value1')\n    COMMIT TRANSACTION inner_tran\nROLLBACK TRANSACTION outer_tran  -- Error: Cannot roll back outer_tran because inner_tran is still active.
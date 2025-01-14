CREATE TABLE action (\n    action_id       BIGINT AUTO_INCREMENT PRIMARY KEY,\n    action_action   CHAR(1) NOT NULL CHECK (action_action IN ('C', 'R', 'F', 'P')),\n    action_size     DECIMAL(9,2) NOT NULL\n);\n\nDELIMITER //\n\nCREATE TRIGGER before_action_insert BEFORE INSERT ON action\nFOR EACH ROW BEGIN\n    IF NEW.action_action = 'F' AND NEW.action_size <> 0.00 THEN\n        SIGNAL SQLSTATE '45000'\n        SET MESSAGE_TEXT = 'action_size must be 0.00 when action_action is F';\n    ELSEIF NEW.action_action <> 'F' AND NEW.action_size <= 0.00 THEN\n        SIGNAL SQLSTATE '45000'\n        SET MESSAGE_TEXT = 'action_size must be greater than 0.00 when action_action is not F';\n    END IF;\nEND//\n\nCREATE TRIGGER before_action_update BEFORE UPDATE ON action\nFOR EACH ROW BEGIN\n    IF NEW.action_action = 'F' AND NEW.action_size <> 0.00 THEN\n        SIGNAL SQLSTATE '45000'\n        SET MESSAGE_TEXT = 'action_size must be 0.00 when action_action is F';\n    ELSEIF NEW.action_action <> 'F' AND NEW.action_size <= 0.00 THEN\n        SIGNAL SQLSTATE '45000'\n        SET MESSAGE_TEXT = 'action_size must be greater than 0.00 when action_action is not F';\n    END IF;\nEND//\n\nDELIMITER ;
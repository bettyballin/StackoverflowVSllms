CREATE TRIGGER TRIGGER_NAME FOR T_NAME\nACTIVE BEFORE INSERT\nAS\nBEGIN\n  NEW.EXPIRATION = DATEADD(day, 30, CURRENT_TIMESTAMP);\nEND;
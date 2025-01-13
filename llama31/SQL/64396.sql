-- Create a message type for the trigger\nCREATE MESSAGE TYPE AuditMessage\nVALIDATION = NONE;\n\n-- Create a contract for the message type\nCREATE CONTRACT AuditContract\n(AuditMessage SENT BY INITIATOR);\n\n-- Create a queue for the trigger\nCREATE QUEUE AuditQueue;\n\n-- Create a service for the queue\nCREATE SERVICE AuditService\nON QUEUE AuditQueue\n(AuditContract);\n\n-- Create a trigger that sends a message to the service\nCREATE TRIGGER AsyncAuditTrigger\nON YourTable\nAFTER INSERT, UPDATE, DELETE\nAS\nBEGIN\n    DECLARE @xml XML;\n    SET @xml = (SELECT * FROM inserted FOR XML PATH('row'));\n    SEND ON CONVERSATION 'AuditService'\n    MESSAGE TYPE AuditMessage (@xml);\nEND;
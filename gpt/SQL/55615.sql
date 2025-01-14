CREATE TRIGGER trg_InsertNotification\nON YourTable\nAFTER INSERT\nAS\nBEGIN\n    DECLARE @MessageBody NVARCHAR(MAX);\n    \n    SELECT @MessageBody = (SELECT * FROM INSERTED FOR XML AUTO);\n    \n    SEND ON CONVERSATION [YourConversationHandle] MESSAGE TYPE [YourMessageType] (@MessageBody);\nEND;
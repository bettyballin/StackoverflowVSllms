-- Enable Service Broker\nALTER DATABASE [YourDatabase] SET ENABLE_BROKER;\n\n-- Create a message type\nCREATE MESSAGE TYPE [OrderChangedMessage] VALIDATION = NONE;\n\n-- Create a contract\nCREATE CONTRACT [OrderChangedContract] ([OrderChangedMessage] SENT BY INITIATOR);\n\n-- Create a queue\nCREATE QUEUE [OrderChangeQueue];\n\n-- Create a service\nCREATE SERVICE [OrderChangeService] ON QUEUE [OrderChangeQueue] ([OrderChangedContract]);\n\n-- Create a trigger to send messages to the queue\nCREATE TRIGGER [trOrderChange] ON [dbo].[Order]\nAFTER INSERT, UPDATE, DELETE\nAS\nBEGIN\n    DECLARE @messageBody NVARCHAR(MAX);\n    SET @messageBody = 'Order has been changed';\n    \n    BEGIN DIALOG CONVERSATION @dialogHandle\n        FROM SERVICE [OrderChangeService]\n        TO SERVICE 'OrderChangeService'\n        ON CONTRACT [OrderChangedContract]\n        WITH ENCRYPTION = OFF;\n\n    SEND ON CONVERSATION @dialogHandle\n        MESSAGE TYPE [OrderChangedMessage]\n        (@messageBody);\nEND;
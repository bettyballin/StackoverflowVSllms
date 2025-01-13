public class BatchProcessor\n{\n    public void ProcessBatch()\n    {\n        // Retrieve data from source system using SQL\n        var data = dbContext.SourceSystemRecords.SqlQuery("SELECT * FROM records");\n\n        // Send messages to a message queue for processing\n        foreach (var record in data)\n        {\n            messageQueue.Send(new TransformRecordMessage(record));\n        }\n    }\n}\n\npublic class TransformRecordMessageHandler\n{\n    public void Handle(TransformRecordMessage message)\n    {\n        // Perform transformations using business rules\n        var transformedRecord = TransformRecord(message.Record);\n\n        // Insert transformed data into target system using SQL\n        dbContext.TargetSystemRecords.SqlBulkInsert(transformedRecord);\n    }\n}
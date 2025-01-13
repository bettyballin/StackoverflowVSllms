CREATE PROCEDURE AddTag\n    @TagName VARCHAR(60),\n    @TaggedRecordId INT\nAS\nBEGIN\n    IF EXISTS (SELECT 1 FROM Tag WHERE TagName = @TagName)\n        INSERT INTO TaggedRecords (TagId, TaggedRecordId)\n        SELECT TagId, @TaggedRecordId FROM Tag WHERE TagName = @TagName\n    ELSE\n        INSERT INTO Tag (TagName)\n        VALUES (@TagName)\n        OUTPUT inserted.TagId INTO @NewTagId\n        INSERT INTO TaggedRecords (TagId, TaggedRecordId)\n        VALUES (@NewTagId, @TaggedRecordId)\nEND
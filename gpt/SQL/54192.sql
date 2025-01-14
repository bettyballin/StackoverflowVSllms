CREATE PROCEDURE AddTagToRecord\n    @TagName VARCHAR(60),\n    @TaggedRecordId INT\nAS\nBEGIN\n    DECLARE @TagId INT;\n\n    -- Check if the tag already exists\n    SELECT @TagId = TagId\n    FROM Tag\n    WHERE TagName = @TagName;\n\n    -- If tag does not exist, insert it into the Tag table and get the new TagId\n    IF @TagId IS NULL\n    BEGIN\n        INSERT INTO Tag (TagName)\n        VALUES (@TagName);\n\n        SET @TagId = SCOPE_IDENTITY();\n    END\n\n    -- Insert the tag and record ID into the TaggedRecords table\n    INSERT INTO TaggedRecords (TagId, TaggedRecordId)\n    VALUES (@TagId, @TaggedRecordId);\nEND;
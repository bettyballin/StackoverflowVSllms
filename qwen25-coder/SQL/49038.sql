CREATE PROCEDURE GetOrInsertTagID\n    @TagName varchar(50),\n    @TagID int OUTPUT\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    -- Check if the TagName exists and retrieve the TagID\n    IF EXISTS (SELECT 1 FROM tbrm_Tags WHERE TagName = @TagName)\n    BEGIN\n        SELECT @TagID = TagID FROM tbrm_Tags WHERE TagName = @TagName;\n    END\n    ELSE\n    BEGIN\n        -- Insert the new TagName and retrieve the newly generated TagID\n        INSERT INTO tbrm_Tags (TagName) VALUES (@TagName);\n        SET @TagID = SCOPE_IDENTITY();\n    END\n\n    -- Return the TagID as part of the result set\n    SELECT @TagID AS TagID;\nEND
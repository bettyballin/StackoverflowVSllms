CREATE PROCEDURE InsertNode\n    @ParentNodeID INT,\n    @Name VARCHAR(50)\nAS\nBEGIN\n    INSERT INTO Tree (ParentNodeID, Name)\n    VALUES (@ParentNodeID, @Name)\nEND\n\nCREATE PROCEDURE UpdateNode\n    @NodeID INT,\n    @Name VARCHAR(50)\nAS\nBEGIN\n    UPDATE Tree\n    SET Name = @Name\n    WHERE NodeID = @NodeID\nEND\n\nCREATE PROCEDURE DeleteNode\n    @NodeID INT\nAS\nBEGIN\n    DELETE FROM Tree\n    WHERE NodeID = @NodeID\nEND
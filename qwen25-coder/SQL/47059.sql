CREATE PROCEDURE GetParentAndChildren\n    @ParentID INT\nAS\nBEGIN\n    -- Select data from TableA\n    SELECT * FROM TableA WHERE ID = @ParentID;\n\n    -- Select related data from TableB (assuming FKColumn is the foreign key)\n    SELECT * FROM TableB WHERE FKColumn = @ParentID;\nEND
-- Create a temp table to hold the last used ID\nCREATE TABLE #NextID (LastID INT NOT NULL);\n\n-- Insert the starting ID or initial value\nINSERT INTO #NextID (LastID) VALUES (0); -- Replace 0 with your actual starting point\n\nGO\n\n-- Define your scalar function to get the next ID\nCREATE FUNCTION dbo.GetNextID()\nRETURNS INT\nAS\nBEGIN\n    DECLARE @nextid INT;\n\n    -- Get the current last ID and increment it\n    UPDATE #NextID SET LastID = LastID + 1 OUTPUT INSERTED.LastID INTO @nextid;\n\n    RETURN @nextid;\nEND\n\nGO\n\n-- Example usage in your script\nINSERT INTO tableOfStuff (someStuff, uniqueID) VALUES ('stuff', dbo.GetNextID());\nINSERT INTO tableOfStuff (someStuff, uniqueID) VALUES ('more stuff', dbo.GetNextID());\n\n-- Clean up after the operation\nDROP TABLE #NextID;
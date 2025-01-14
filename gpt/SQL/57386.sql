DECLARE @ChildList TABLE (ChildID INT);\nINSERT INTO @ChildList (ChildID) VALUES (1), (2), (3); -- Replace with actual child IDs you want to filter by\n\nSELECT Parent.ParentID, Parent.ParentName\nFROM Parent\nINNER JOIN ParentChild ON Parent.ParentID = ParentChild.ParentID\nINNER JOIN @ChildList CL ON ParentChild.ChildID = CL.ChildID\nGROUP BY Parent.ParentID, Parent.ParentName\nHAVING COUNT(DISTINCT ParentChild.ChildID) = (SELECT COUNT(*) FROM @ChildList);
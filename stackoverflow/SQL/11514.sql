SELECT Tags.ID, Tags.Name, Tags.SortOrder, Tags.ParentID,\n       COUNT(DISTINCT ProductTags.ProductID) AS ProductCount, \n       COUNT(DISTINCT ChildTags.ID) AS ChildTagCount\nFROM Tags\nLEFT OUTER JOIN ProductTags ON Tags.ID = ProductTags.TagID\nLEFT OUTER JOIN Tags ChildTags ON Tags.ID = ChildTags.ParentID\nGROUP BY Tags.ID, Tags.Name, Tags.SortOrder, Tags.ParentID
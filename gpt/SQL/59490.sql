SELECT T.TagName\nFROM Tags T\nJOIN ItemTags IT ON T.TagID = IT.TagID\nWHERE IT.ItemID = 1;
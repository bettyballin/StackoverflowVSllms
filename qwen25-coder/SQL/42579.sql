select a.Name, b.Status from a\ninner join b\non a.StatusID = b.ID  -- or b.ID = a.StatusID, both are equivalent
var items = db.Items.Where(i => i.TagMaps.Any(tm => tagIds.Contains(tm.TagId)));
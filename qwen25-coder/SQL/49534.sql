SELECT firstname, COUNT(*) as count \nFROM Customers \nGROUP BY firstname \nHAVING COUNT(*) > 1\nORDER BY firstname;
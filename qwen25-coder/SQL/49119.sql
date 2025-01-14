CREATE VIEW TagDetailsView AS\nSELECT \n    t.id,\n    t.name,\n    t.sortorder,\n    t.parentid,\n    COUNT(udt.productid) AS ProductCount,\n    COUNT(child.tagid) AS ChildTagCount\nFROM \n    Tags t\nLEFT JOIN \n    (SELECT DISTINCT tagid, productid FROM ProductTags) udt ON udt.tagid = t.id\nLEFT JOIN \n    Tags child ON child.parentid = t.id\nGROUP BY \n    t.id, t.name, t.sortorder, t.parentid;
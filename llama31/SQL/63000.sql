SELECT \n    c.Name, \n    c.Address, \n    STUFF((SELECT ',' + r.Name \n           FROM ContactRole cr \n           INNER JOIN Role r ON cr.RoleID = r.ID \n           WHERE cr.ContactID = c.ID \n           FOR XML PATH('')), 1, 1, '') AS Roles\nFROM Contact c
SELECT \n    t.ticketid, \n    u.userid, \n    t.fullname, \n    u.loginapi_userid, \n    t.email, \n    tp.subject, \n    tp.contents, \n    a.PhoneNumber, \n    a.Location, \n    a.Extension, \n    a.BusinessUnit, \n    a.Department\nFROM \n    swtickets t\nINNER JOIN \n    swticketposts tp ON t.ticketid = tp.ticketid\nINNER JOIN \n    swusers u ON t.userid = u.userid\nLEFT JOIN (\n    SELECT \n        cfv.typeid,\n        MIN(CASE WHEN cfv.customfieldid = 1 THEN cfv.fieldvalue END) AS 'PhoneNumber',\n        MIN(CASE WHEN cfv.customfieldid = 3 THEN cfv.fieldvalue END) AS 'Location',\n        MIN(CASE WHEN cfv.customfieldid = 5 THEN cfv.fieldvalue END) AS 'Extension',\n        MIN(CASE WHEN cfv.customfieldid = 8 THEN cfv.fieldvalue END) AS 'BusinessUnit',\n        MIN(CASE WHEN cfv.customfieldid = 9 THEN cfv.fieldvalue END) AS 'Department'\n    FROM \n        swcustomfieldvalues cfv\n    GROUP BY \n        cfv.typeid\n) a ON t.ticketid = a.typeid\nWHERE \n    t.ticketid = 2458;
SELECT t.ticketid, u.userid, t.fullname, u.loginapi_userid, t.email, tp.subject, tp.contents, a.PhoneNumber, a.Location, a.Extension, a.BusinessUnit, a.Department\nFROM swtickets t\nINNER JOIN swticketposts tp ON t.ticketid = tp.ticketid\nINNER JOIN swusers u ON t.userid = u.userid\nLEFT JOIN (\n  SELECT \n    cfv.typeid,\n    MIN(CASE cfv.customfieldid WHEN 1 THEN cfv.fieldvalue END) AS 'PhoneNumber',\n    MIN(CASE cfv.customfieldid WHEN 3 THEN cfv.fieldvalue END) AS 'Location',\n    MIN(CASE cfv.customfieldid WHEN 5 THEN cfv.fieldvalue END) AS 'Extension',\n    MIN(CASE cfv.customfieldid WHEN 8 THEN cfv.fieldvalue END) AS 'BusinessUnit',\n    MIN(CASE cfv.customfieldid WHEN 9 THEN cfv.fieldvalue END) AS 'Department'\n  FROM swcustomfieldvalues cfv\n  GROUP BY cfv.typeid\n) AS a ON a.typeid = t.ticketid\nWHERE t.ticketid = 2458;
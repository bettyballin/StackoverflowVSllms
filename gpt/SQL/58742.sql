SELECT qp.id, qp.requestid, qp.QuotePraposalLink, qp.comment\nFROM tblquoteproposal qp\nJOIN (\n    SELECT MAX(id) AS max_id\n    FROM tblquoteproposal\n    WHERE requestid IN (\n        SELECT requestid\n        FROM tblrequest\n        WHERE Customerid = 3\n    )\n    GROUP BY requestid\n) latest ON qp.id = latest.max_id\nORDER BY qp.requestid;
PREPARE stmt FROM 'SELECT MAX(qp.id) AS latest_id, qp.requestid\nFROM tblquoteproposal qp\nJOIN tblrequest r ON qp.requestid = r.requestid\nWHERE r.customerid = ?\nGROUP BY qp.requestid\nORDER BY qp.id DESC\nLIMIT 1';\n\nEXECUTE stmt USING @customerid;
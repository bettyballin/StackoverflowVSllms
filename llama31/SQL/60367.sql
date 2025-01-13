UPDATE c\nSET c.contract_parent_id = p.ID\nFROM contract c\nINNER JOIN tbl_contract tc ON c.contract_pk = tc.contract_pk\nINNER JOIN contract p ON tc.contract_parent_id = p.contract_pk;
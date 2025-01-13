SELECT orders.* \nFROM orders \nINNER JOIN (SELECT userid, RAND() as random FROM users) tmp\nON orders.userid = tmp.userid\nORDER BY tmp.random, tmp.userid
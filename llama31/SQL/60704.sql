SELECT u.user_id, u.pic_url, u.name, a.auto_id, a.userid, a.type, a.subject, a.body, a.datetime\nFROM actions AS a\nINNER JOIN users AS u ON u.user_id = a.userid\nINNER JOIN friends AS f ON f.userid = a.userid\nWHERE (f.friendid = 1 OR a.userid = 1)  // 1 would be your user ID\n  AND f.status = 'active';
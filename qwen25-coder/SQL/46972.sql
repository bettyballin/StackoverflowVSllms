SELECT u.*, i.*, e.* FROM users u\nINNER JOIN images i ON i.imageid = u.imageid\nINNER JOIN events e ON e.userid = u.userid
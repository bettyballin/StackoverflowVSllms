UPDATE users\nJOIN usersold ON users.id = usersold.id\nSET users.status = 1;
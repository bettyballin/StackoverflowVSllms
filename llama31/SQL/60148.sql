SELECT u.username, p.name, p.email \nFROM users u \nJOIN people p ON u.person_id = p.person_id \nWHERE u.username = 'example_user';
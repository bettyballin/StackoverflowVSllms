public IReadOnlyList<User> GetAllUsers()\n{\n    return _users.AsReadOnly();\n}
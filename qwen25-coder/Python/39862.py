def insert(table_name, record):\n    table = db.get(table_name)\n    if not table:\n        return "Table does not exist"\n    \n    for col, value in record.items():\n        if col in table:\n            table[col].append(value)\n\ninsert('users', {'id': 3, 'name': 'Charlie', 'age': 40})\nprint(db['users'])
columns_to_retrieve = [users_table.c.user_id, users_table.c.user_name]\nif some_condition:\n    columns_to_retrieve.append(users_table.c.user_country)\n\ns = select(columns_to_retrieve).where(users_table.c.user_name == username)
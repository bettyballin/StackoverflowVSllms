from sqlalchemy import create_engine, MetaData, Table\n\n# Assuming 'engine' is already defined\nmetadata = MetaData(bind=engine)\n\n# Reflect the existing table\nusers_table = Table('fusion_users', metadata, autoload_with=engine)\n\n# Specify the columns you want to select (exclude user_password)\ncolumns_to_select = [users_table.c.user_id, users_table.c.user_name, users_table.c.user_country]\n\n# Create a select statement with these specific columns and filter by username\nselect_stmt = users_table.select().where(users_table.c.user_name == username).with_only_columns(*columns_to_select)\n\n# Execute the query\nwith engine.connect() as connection:\n    result = connection.execute(select_stmt)\n    rows = result.all()\n\n# Process results\nif not rows:\n    print('Sorry, user not found.')\nelse:\n    for row in rows:\n        # row.items() is now available and returns a dictionary of column-value pairs\n        for col_name, value in row.items():\n            print(col_name, value)
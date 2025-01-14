from sqlalchemy import create_engine, Table, MetaData, select\n\n# Create an engine and connect\nengine = create_engine('sqlite:///example.db')\nconnection = engine.connect()\n\n# Reflect the database schema\nmetadata = MetaData()\nusers_table = Table('users', metadata, autoload_with=engine)\n\n# Using ORM-style query (less performance control but easy to use)\nresult_orm = connection.execute(select(users_table).where(users_table.c.age > 30)).fetchall()\n\n# Example of a raw SQL string query for potentially better performance\ncustom_query = "SELECT * FROM users WHERE age > 30"\nresult_custom_sql = connection.execute(custom_query).fetchall()
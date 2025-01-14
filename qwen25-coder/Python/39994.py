from sqlalchemy import create_engine, MetaData, Table\n\n# Create a connection to your database\nengine = create_engine('your_database_connection_string')\nmetadata = MetaData()\ntable_a = Table('TABLE_A', metadata, autoload_with=engine)\ntable_b = Table('TABLE_B', metadata, autoload_with=engine)\n\n# Construct the SELECT statement columns dynamically with prefixes\nselect_columns = []\nfor column in table_a.columns:\n    select_columns.append(f"a.{column.name}")\nfor column in table_b.columns:\n    select_columns.append(f"b.{column.name} as 'b_{column.name}'")\n\nselect_query = f"SELECT {', '.join(select_columns)} FROM TABLE_A a JOIN TABLE_B b USING (some_id);"\n\n# Execute the query\nwith engine.connect() as connection:\n    result = connection.execute(select_query).fetchall()\n\n# If using pandas for easier visualization or processing\nimport pandas as pd\ndf = pd.DataFrame(result, columns=[col.split('.')[-1].split(' as ')[-1].replace("'", "") for col in select_columns])\nprint(df)
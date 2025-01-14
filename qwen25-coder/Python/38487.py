from sqlalchemy import create_engine, Table, MetaData, func\n\n# Assuming you have your engine and metadata set up\nengine = create_engine('sqlite:///yourdatabase.db')\nmetadata = MetaData(bind=engine)\ntable = Table('your_table', metadata, autoload_with=engine)\n\nwith engine.connect() as connection:\n    random_row = connection.execute(\n        table.select().order_by(func.random()).limit(1)\n    ).fetchone()\n\nprint(random_row)
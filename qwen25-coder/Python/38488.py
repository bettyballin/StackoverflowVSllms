from sqlalchemy import create_engine, Table, MetaData, func\n\n# Assuming you have your engine and metadata set up\nengine = create_engine('mysql+pymysql://user:password@localhost/yourdatabase')\nmetadata = MetaData(bind=engine)\ntable = Table('your_table', metadata, autoload_with=engine)\n\nwith engine.connect() as connection:\n    random_row = connection.execute(\n        table.select().order_by(func.rand()).limit(1)\n    ).fetchone()\n\nprint(random_row)
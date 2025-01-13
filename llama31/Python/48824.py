# Example using SQLAlchemy (Python)\nfrom sqlalchemy import create_engine, select, join\n\nengine = create_engine('postgresql://user:password@host:port/dbname')\nBase = declarative_base()\n\nclass Table1(Base):\n    __tablename__ = 'table1'\n    id = Column(Integer, primary_key=True)\n    column = Column(String)\n\nclass Table2(Base):\n    __tablename__ = 'table2'\n    id = Column(Integer, primary_key=True)\n    column = Column(String)\n\n# Define your query\nquery = select([Table1]).select_from(join(Table1, Table2, Table1.column == Table2.column))\n\n# Execute the query\nresult = engine.execute(query).fetchall()
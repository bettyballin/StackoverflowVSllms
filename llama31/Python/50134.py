from sqlalchemy import create_engine, Column, Integer, String\nfrom sqlalchemy.ext.declarative import declarative_base\nfrom sqlalchemy.orm import sessionmaker\n\nBase = declarative_base()\n\nclass User(Base):\n    __tablename__ = 'users'\n    id = Column(Integer, primary_key=True)\n    name = Column(String)\n    age = Column(Integer)\n\n# create a sample dataset\nusers = [User(name='John', age=25), User(name='Mary', age=31), User(name='David', age=42)]\n\n# create an in-memory engine\nengine = create_engine('sqlite:///:memory:')\n\n# perform a query\nSession = sessionmaker(bind=engine)\nsession = Session()\nresult = session.query(User).filter(User.age > 30).all()\nprint(result)
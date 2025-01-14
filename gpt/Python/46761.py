from sqlalchemy import create_engine, Column, Integer, String\nfrom sqlalchemy.ext.declarative import declarative_base\nfrom sqlalchemy.orm import sessionmaker\n\nengine = create_engine('sqlite:///example.db', echo=True)\nBase = declarative_base()\n\nclass User(Base):\n    __tablename__ = 'users'\n    id = Column(Integer, primary_key=True)\n    name = Column(String)\n    age = Column(Integer)\n\nBase.metadata.create_all(engine)\n\nSession = sessionmaker(bind=engine)\nsession = Session()\n\n# Adding a new user\nnew_user = User(name='John Doe', age=30)\nsession.add(new_user)\nsession.commit()\n\n# Querying the database\nfor user in session.query(User).all():\n    print(user.name, user.age)
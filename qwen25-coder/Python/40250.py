# Example of basic CRUD operations using SQLAlchemy\n\nfrom sqlalchemy import create_engine, Column, Integer, String\nfrom sqlalchemy.ext.declarative import declarative_base\nfrom sqlalchemy.orm import sessionmaker\n\nBase = declarative_base()\n\nclass User(Base):\n    __tablename__ = 'users'\n    id = Column(Integer, primary_key=True)\n    name = Column(String)\n\n# Setup Engine and Session\nengine = create_engine('mysql+pymysql://user:password@localhost/dbname')\nSession = sessionmaker(bind=engine)\nsession = Session()\n\n# Add a new user\nnew_user = User(name='John Doe')\nsession.add(new_user)\nsession.commit()\n\n# Query for users\nusers = session.query(User).filter_by(name='John Doe').all()\nfor user in users:\n    print(user.name)\n\n# Close the session\nsession.close()
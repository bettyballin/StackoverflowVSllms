from sqlalchemy import create_engine, Column, Integer, String\nfrom sqlalchemy.ext.declarative import declarative_base\nfrom sqlalchemy.orm import sessionmaker\n\nBase = declarative_base()\n\nclass User(Base):\n    __tablename__ = 'users'\n    id = Column(Integer, primary_key=True)\n    name = Column(String)\n    email = Column(String)\n\nengine = create_engine('sqlite:///example.db')\nBase.metadata.create_all(engine)\n\nSession = sessionmaker(bind=engine)\nsession = Session()\n\n# Adding a new user\nnew_user = User(name='John Doe', email='john.doe@example.com')\nsession.add(new_user)\nsession.commit()
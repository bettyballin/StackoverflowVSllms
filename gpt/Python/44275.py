from sqlalchemy import create_engine, Column, String, Integer, MetaData, Table, null\nfrom sqlalchemy.ext.declarative import declarative_base\nfrom sqlalchemy.orm import sessionmaker\n\nBase = declarative_base()\n\nclass User(Base):\n    __tablename__ = 'users'\n    id = Column(Integer, primary_key=True)\n    first_name = Column(String, nullable=True)\n    last_name = Column(String, nullable=False)\n\nDATABASE_URI = 'sqlite:///example.db'\nengine = create_engine(DATABASE_URI)\nSession = sessionmaker(bind=engine)\nsession = Session()\n\ndef create_user(first_name, last_name):\n    if not last_name:\n        raise ValueError("Last name is required")\n    user = User(\n        first_name=first_name if first_name else None,  # Set to NULL if empty\n        last_name=last_name\n    )\n    session.add(user)\n    session.commit()\n\n# Example usage\ntry:\n    create_user("", "Doe")  # This will set first_name to NULL\nexcept ValueError as e:\n    print(e)
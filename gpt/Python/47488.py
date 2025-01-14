from sqlalchemy import create_engine, Column, Integer, String\nfrom sqlalchemy.ext.declarative import declarative_base\nfrom sqlalchemy.types import TypeDecorator, VARCHAR\nimport json\n\nBase = declarative_base()\n\nclass JSONEncodedSet(TypeDecorator):\n    """Represents an immutable structure as a json-encoded string."""\n    impl = VARCHAR\n\n    def process_bind_param(self, value, dialect):\n        if value is not None:\n            value = json.dumps(list(value))\n        return value\n\n    def process_result_value(self, value, dialect):\n        if value is not None:\n            value = set(json.loads(value))\n        return value\n\nclass User(Base):\n    __tablename__ = 'users'\n    id = Column(Integer, primary_key=True)\n    name = Column(String)\n    permissions = Column(JSONEncodedSet)\n\nclass Group(Base):\n    __tablename__ = 'groups'\n    id = Column(Integer, primary_key=True)\n    name = Column(String)\n    permissions = Column(JSONEncodedSet)\n\nclass Page(Base):\n    __tablename__ = 'pages'\n    id = Column(Integer, primary_key=True)\n    name = Column(String)\n    group_permissions = Column(JSONEncodedSet)\n\n# Example Usage\nengine = create_engine('sqlite:///:memory:')\nBase.metadata.create_all(engine)\n\nfrom sqlalchemy.orm import sessionmaker\n\nSession = sessionmaker(bind=engine)\nsession = Session()\n\n# Creating entries\nuser = User(name="John Doe", permissions={"read", "write"})\ngroup = Group(name="Admins", permissions={"admin"})\npage = Page(name="HomePage", group_permissions={"view", "edit"})\n\nsession.add(user)\nsession.add(group)\nsession.add(page)\nsession.commit()\n\n# Querying and manipulating sets\nqueried_user = session.query(User).filter_by(name="John Doe").first()\nqueried_user.permissions.add("delete")\nsession.commit()\n\nprint(queried_user.permissions)  # Output: {'read', 'write', 'delete'}
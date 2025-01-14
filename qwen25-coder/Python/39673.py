import json\nfrom sqlalchemy import create_engine, Table, Column, Integer, String, MetaData\n\n# Sample CouchDB Document in JSON format\ncouchdb_doc = '''\n{\n    "_id": "user_123",\n    "type": "user",\n    "name": "John Doe",\n    "email": "john.doe@example.com",\n    "age": 30\n}\n'''\n\n# Load JSON document\ndata = json.loads(couchdb_doc)\n\n# SQLAlchemy setup for MySQL\nengine = create_engine('mysql+pymysql://username:password@localhost/database')\nmetadata = MetaData()\nconnection = engine.connect()\n\n# Define table in MySQL schema\nusers_table = Table('users', metadata,\n                    Column('id', Integer, primary_key=True),\n                    Column('name', String(50)),\n                    Column('email', String(100)),\n                    Column('age', Integer))\n\nmetadata.create_all(engine)\n\n# Insert data into the MySQL table\ninsert_stmt = users_table.insert().values(id=data['_id'].split('_')[1], \n                                         name=data['name'], \n                                         email=data['email'], \n                                         age=data['age'])\nconnection.execute(insert_stmt)
from peewee import SqliteDatabase, Model, CharField\n\n   db = SqliteDatabase('example.db')\n\n   class ExampleModel(Model):\n       name = CharField()\n\n       class Meta:\n           database = db
from sqlalchemy import Table, Column, Integer, Boolean\n\nmy_table = Table('my_table', metadata,\n    Column('id', Integer, primary_key=True),\n    Column('is_deleted', Boolean)\n)\n\nmy_table.filter = my_table.c.is_deleted == 0
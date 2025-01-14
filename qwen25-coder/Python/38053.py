import tables\n   \n   class Data(tables.IsDescription):\n       subkey = tables.StringCol(20)\n   \n   h5file = tables.open_file('data.h5', mode='w')\n   group = h5file.create_group("/", 'group', 'Group storing a dataset')\n   table = h5file.create_table(group, 'table', Data, 'A table with data')\n   row = table.row
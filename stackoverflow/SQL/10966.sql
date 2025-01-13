select \n   omID,\n   T.Fruit.query('.')\nfrom \n   dbo.myTable\ncross apply\n   omText.nodes('/things/Fruit') as T(Fruit)\nwhere \n   T.Fruit.value('(title)[1]', 'varchar(50)') = 'X'
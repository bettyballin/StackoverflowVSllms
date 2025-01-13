WITH Pieces(id, newdesc) AS\n(\n  SELECT itemid, REPLACE(REPLACE(description, 'DESC_A', 'DESC_B'), 'NEW_1', 'NEW_2')\n  FROM myTable\n  WHERE description like '%DESC_A%DESC_B%'\n)\nUPDATE m\nSET description = p.newdesc\nFROM myTable m\nINNER JOIN Pieces p ON m.itemid = p.id;
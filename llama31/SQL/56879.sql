SELECT * FROM A WHERE id IN (SELECT id FROM B) => SELECT A.* FROM A JOIN B ON A.id = B.id
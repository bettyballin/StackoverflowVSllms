SELECT child.*\n     FROM tags AS parent, tags AS child\n     WHERE child.lft BETWEEN parent.lft AND parent.rgt\n     AND parent.id = ?;
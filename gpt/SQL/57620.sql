SELECT mt.*\nFROM MainTable mt\nINNER JOIN LinkerTable lt ON mt.id = lt.child_id\nWHERE lt.parent_id = ?;
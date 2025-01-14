WITH RECURSIVE components AS (\n       SELECT set1 AS set_id, set1 AS component_id\n       FROM edges\n       UNION\n       SELECT e.set2, c.component_id\n       FROM edges e\n       JOIN components c ON e.set1 = c.set_id\n   )\n   SELECT DISTINCT component_id, set_id\n   INTO TEMPORARY TABLE component_sets\n   FROM components;
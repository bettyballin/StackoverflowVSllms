CREATE VIEW my_view AS\n   SELECT column1, column2\n   FROM my_table\n   WHERE column1 > 0\n   WITH CHECK OPTION;
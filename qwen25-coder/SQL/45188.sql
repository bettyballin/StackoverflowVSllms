declare global temporary table session.tt_testingSyntax (\n    id int\n) on commit preserve rows not logged;\n\ninsert into session.tt_testingSyntax (id) values (1);\ninsert into session.tt_testingSyntax (id) values (2);\ninsert into session.tt_testingSyntax (id) values (3);\ninsert into session.tt_testingSyntax (id) values (4);\n\nselect * from session.tt_testingSyntax;
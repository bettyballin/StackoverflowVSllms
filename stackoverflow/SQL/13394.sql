* $insert_id = INSERT...RETURNING foo_id;-- only works for PostgreSQL >= 8.2. \n\n * INSERT...; $insert_id = SELECT lastval(); -- works for PostgreSQL >= 8.1\n\n * $insert_id = SELECT nextval('foo_seq'); INSERT INTO table (foo...) values ($insert_id...) for older PostgreSQL (and newer PostgreSQL)
CREATE EXTENSION pg_stat_statements;\nALTER SYSTEM SET pg_stat_statements.max = 10000;\nALTER SYSTEM SET pg_stat_statements.track = 'all';
CREATE TABLE t (a INTEGER, b INTEGER);\n\nCREATE UNIQUE INDEX unique_ab ON t (LEAST(a, b), GREATEST(a, b));
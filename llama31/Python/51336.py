import psycopg2.sql\n\nvalue = "Unsafe string"\nquery = psycopg2.sql.SQL("SELECT * FROM some_table WHERE some_char_field = {}").format(psycopg2.sql.Literal(value))\ncursor.execute(query)
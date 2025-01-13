import lark\n\n# Define the grammar for your language\ngrammar = """\nstart: statement*\n\nstatement: create_table | select_statement | insert_statement\n\ncreate_table: "CREATE TABLE" table_name "(" column_def ("," column_def)* ")"\ntable_name: CNAME\ncolumn_def: column_name column_type\ncolumn_name: CNAME\ncolumn_type: "INT" | "VARCHAR" | "BOOLEAN"\n\nselect_statement: "SELECT" columns "FROM" table_name\ncolumns: "*"\n\ninsert_statement: "INSERT INTO" table_name "VALUES" "(" value ("," value)* ")"\nvalue: SIGNED_NUMBER | ESCAPED_STRING\n\n%import common.CNAME\n%import common.SIGNED_NUMBER\n%import common.ESCAPED_STRING\n%import common.WS\n%ignore WS\n"""\n\n# Create the parser\nparser = lark.Lark(grammar)\n\n# Example usage\nquery = "CREATE TABLE users (id INT, name VARCHAR, active BOOLEAN)"\ntree = parser.parse(query)\nprint(tree.pretty())
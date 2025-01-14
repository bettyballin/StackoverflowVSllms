from lark import Lark\n\n# Define an EBNF grammar as a string\ngrammar = """\n    start: sum\n    ?sum: product\n        | sum "+" product   -> add\n        | sum "-" product   -> sub\n    ?product: atom\n            | product "*" atom  -> mul\n            | product "/" atom  -> div\n    ?atom: NUMBER           -> number\n         | "(" sum ")"\n    \n    %import common.NUMBER\n    %import common.WS\n    %ignore WS\n"""\n\n# Create a Lark parser with the given grammar\nparser = Lark(grammar)\n\n# Parse some input data\nparse_tree = parser.parse("1 + 2 * 3")\n\n# Print the resulting parse tree\nprint(parse_tree.pretty())
require 'treetop'\n\n# Define an EBNF grammar as a string\ngrammar_definition = %q(\n  grammar Calculator\n    rule sum\n      product space ('+' / '-') space product\n    end\n\n    rule product\n      factor space ('*' / '/') space factor\n    end\n\n    rule factor\n      number / space '(' space sum space ')'\n    end\n\n    rule number\n      [0-9]+\n    end\n\n    rule space\n      ' '+\n    end\n  end\n)\n\n# Parse the grammar definition\nTreetop.load_grammar(grammar_definition)\ncalculator = CalculatorParser.new\n\n# Parse some input data\nparse_tree = calculator.parse("1 + 2 * 3")\nputs parse_tree.inspect
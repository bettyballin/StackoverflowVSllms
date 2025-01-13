import pyparsing as pp\n\nparam_name = pp.Word(pp.alphanums + ' ')\nparam_value = pp.Word(pp.alphanums)\nparam_assignment = param_name('name') + pp.Literal('=').suppress() + param_value('value')\nallocation_syntax = pp.Literal('Allocation(').suppress() + pp.delimitedList(param_assignment) + pp.Literal(')').suppress()\n\ndef parse_allocation(allocation_str):\n    parsed_kwargs = allocation_syntax.parseString(allocation_str)\n    kwargs = {param.name: param.value for param in parsed_kwargs}\n    return kwargs\n\n# Usage\nallocation_str = "Allocation(Param 1 = Val1, Param 2 = Val2)"\nkwargs = parse_allocation(allocation_str)\nAllocation(**kwargs)
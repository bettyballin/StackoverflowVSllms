from RestrictedPython import compile_restricted\n   from RestrictedPython.Eval import default_guarded_getitem\n   from RestrictedPython.Guards import safe_builtins\n\n   def evaluate_expression(expression, variables):\n       code = compile_restricted(expression, '<string>', 'eval')\n       context = {\n           '__builtins__': safe_builtins,\n           '_getattr_': None,\n           '_getitem_': default_guarded_getitem,\n           '_getiter_': iter,\n           '_iter_unpack_sequence_': iter,\n           '_print_': None,\n           '_write_': None,\n       }\n       context.update(variables)\n       return eval(code, context)\n\n   expression = "a + b"\n   variables = {'a': 5, 'b': 10}\n   result = evaluate_expression(expression, variables)\n   print(result)  # Output: 15
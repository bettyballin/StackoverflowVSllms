list_of_variable_names = ['foo', 'bar', 'baz']\nd = {name: locals()[name] for name in list_of_variable_names if name in locals()}
# "Dirty" URL\nurl = "http://example.com/?action=hello&sub=world"\nvariables = get_variables(url)\nprint(variables)  # {'action': 'hello', 'sub': 'world'}\n\n# "Clean" URL\nurl = "http://example.com/hello/world"\nvariables = get_variables(url)\nprint(variables)  # {'param_0': 'hello', 'param_1': 'world'}
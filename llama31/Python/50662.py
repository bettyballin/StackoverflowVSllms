def make_bold(func):\n    def wrapper():\n        return "<b>" + func() + "</b>"\n    return wrapper\n\ndef make_italic(func):\n    def wrapper():\n        return "<i>" + func() + "</i>"\n    return wrapper\n\n@make_bold\n@make_italic\ndef say():\n    return "Hello"\n\nprint(say())  # Outputs: <b><i>Hello</i></b>
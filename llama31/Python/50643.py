obj = MyObject()\nmethod_name = 'my_method'\nparams = ['arg1', 'arg2']\n\nmethod = getattr(obj, method_name)\nmethod(*params)
class Obj:\n    def __str__(self):\n        return 'name'\n\nobj_list = [Obj(), Obj(), Obj()]\nresult = ', '.join(str(obj) for obj in obj_list)\nprint(result)  # Output: name, name, name
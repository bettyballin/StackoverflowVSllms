>>> class Foo:\n...     def bar(hello=None):\n...          return hello\n...     def baz(world=None):\n...          return baz\n...\n>>> import inspect\n>>> members = inspect.getmembers(Foo)\n>>> print members\n[('__doc__', None), ('__module__', '__main__'), ('bar', <unbound method Foo.bar>\n), ('baz', <unbound method Foo.baz>)]\n>>> inspect.getargspec(members[2][1])\n(['hello'], None, None, (None,))\n>>> inspect.getargspec(members[3][1])\n(['world'], None, None, (None,))
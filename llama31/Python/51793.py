import sys\nsys.modules[__name__ + 'x'] = __import__('foo')
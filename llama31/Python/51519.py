def my_func(**kwargs):\n    defaults = {'name': 'rob', 'count': 5, 'an_array': ['A string', 5, object()]}\n    kwargs = {**defaults, **kwargs}\n    \n    # ...\n}\n\n# Example usage:\nmy_func(name='John', count=10)
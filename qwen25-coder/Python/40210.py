import inspect\n\ndef parse_class(cls):\n    # Initialize the result dictionary\n    result = {\n        'class': cls.__name__,\n        'methods': []\n    }\n    \n    # Iterate over the members of the class to find methods\n    for name, member in inspect.getmembers(cls, predicate=inspect.isfunction):\n        # Get method's signature\n        sig = inspect.signature(member)\n        \n        # Extract parameter names and types (if any)\n        params = [\n            {\n                'name': param.name,\n                'type': str(param.annotation) if param.annotation is not param.empty else None\n            }\n            for param in sig.parameters.values()\n        ]\n        \n        # Append method details to the result\n        method_info = {'name': name, 'params': params}\n        result['methods'].append(method_info)\n    \n    return result\n\n# Example usage\nclass Foo:\n    def bar(self, hello: str=None):\n         return hello\n\n    def baz(self, world: int=None):\n         return world\n\nparsed_data = parse_class(Foo)\nprint(parsed_data)
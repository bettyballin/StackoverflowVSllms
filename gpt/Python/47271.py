class MyClass:\n    """A simple example class"""\n    def __init__(self, value):\n        self.value = value\n\n    def f(self):\n        return f'hello world, value is {self.value}'\n\n# Create an instance of MyClass\nobj = MyClass(12345)\n\n# Call the method f\nprint(obj.f())  # Output: hello world, value is 12345
class DynamicClass:\n    def __init__(self):\n        self.static_attribute = "I am static"\n\n# Creating an instance of the class\nobj = DynamicClass()\n\n# Adding a new attribute\nobj.new_attribute = "I am dynamic"\nprint(obj.new_attribute)  # Output: I am dynamic\n\n# Adding a new method to the class at runtime\ndef dynamic_method(self):\n    return "This is a dynamically added method!"\n\nDynamicClass.dynamic_method = dynamic_method\nprint(obj.dynamic_method())  # Output: This is a dynamically added method!\n\n# Removing an attribute\ndel obj.new_attribute\n# print(obj.new_attribute)  # Uncommenting this will raise an AttributeError\n\n# Removing a method\ndel DynamicClass.dynamic_method\n# print(obj.dynamic_method())  # Uncommenting this will raise an AttributeError
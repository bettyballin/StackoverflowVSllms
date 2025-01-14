# Assuming you require 'some_library'\nrequire 'some_library'\n\n# List methods of the main object that might be extended by include or require\nputs "Methods available in the main object: #{self.methods.sort}"\n\n# If you know a specific module/class name, inspect it directly\nputs "Methods in SomeModule: #{SomeModule.instance_methods.sort}" if defined?(SomeModule)
require 'fiddle'\nrequire 'fiddle/import'\n\n# Load the DLL\ndll_path = 'path_to_your_dll.dll'\ndll = Fiddle.dlopen(dll_path)\n\n# Define the function signature and get a handle to the function\n# Example: int example_function(int)\nfunction_name = 'example_function'\nexample_function = Fiddle::Function.new(\n  dll[Fiddle::Handle::DEFAULT['example_function']],\n  [Fiddle::TYPE_INT],\n  Fiddle::TYPE_INT\n)\n\n# Call the function\nresult = example_function.call(42)\nputs "Result: #{result}"
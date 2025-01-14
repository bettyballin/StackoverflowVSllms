require 'ffi'\n\nmodule MyDLL\n  extend FFI::Library\n\n  # Specify the path to your DLL, or omit it to let the system find it\n  ffi_lib 'user32' # Example: User32.dll for basic GUI functions on Windows\n\n  # Define a function from the DLL you want to call\n  attach_function :message_box, [:pointer, :string, :string, :int], :int\nend\n\n# Use the function\n# MB_OK is 0; it represents OK button in MessageBox\nresult = MyDLL.message_box(nil, "Hello, this is a message from Ruby!", "Greeting", 0)\nputs "Result: #{result}"
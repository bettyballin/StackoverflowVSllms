# Load the C++/CLI Wrapper DLL in R\ndyn.load("路径\\到\\你的Dll.dll")\n\n# Call the exported function\n.Call(C_function_symbol(.C_get_default_dll_name(), "CallManagedCode"))
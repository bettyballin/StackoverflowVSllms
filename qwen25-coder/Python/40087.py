import ctypes\n\n# Your original message\nmsg = "hello world"\n\n# Encode the string to bytes\nbyte_msg = msg.encode('utf-8')\n\n# Use ctypes.create_string_buffer to create a buffer for our message\nbuffer = ctypes.create_string_buffer(byte_msg)\n\n# Get the pointer from the buffer, which can be passed as void*\ndata = ctypes.c_void_p(ctypes.addressof(buffer))\n\n# Example of passing data to some function in a DLL (assuming `some_function` takes void*):\n# dll.some_function(data)
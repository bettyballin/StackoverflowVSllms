# Example of handling raw input as bytes\ninput_data = sys.stdin.buffer.read()\n\nform = cgi.FieldStorage(\n    fp=input_data,\n    environ={'REQUEST_METHOD': 'POST'},\n    keep_blank_values=True,\n    strict_parsing=False\n)
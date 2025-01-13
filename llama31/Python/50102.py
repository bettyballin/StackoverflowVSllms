import struct\n\nfield_widths = [10, 20, 30, 20]\ndata = ["Foo", "Bar", "Baz", "Qux"]\n\nformat_string = "".join("{}".format(width) for width in field_widths)\npacked_string = struct.pack(format_string, *data)\n\nprint(packed_string.decode())
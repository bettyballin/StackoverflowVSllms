def convert_to_string(data)\n  data = data.dup # make a copy to avoid modifying the original array\n  data.pop while data.last == 0 # remove trailing null bytes\n  data.pack("c" * data.size).gsub("\x00", "\xFF") # replace null bytes with placeholder\nend
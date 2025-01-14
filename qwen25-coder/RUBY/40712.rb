def bytes_to_binary_string(bytes)\n  # Remove trailing zeros while keeping at least the first two elements\n  trimmed_bytes = bytes[0, 2]\n  trimmed_bytes.pack("c*")\nend\n\n# Example usage:\nstart_time = bytes_to_binary_string([214, 222, 0, 0, 0])\nend_time = bytes_to_binary_string([214, 223, 0, 0, 0])\n\nBasic.where("start_time > ? AND end_time < ?", start_time, end_time)
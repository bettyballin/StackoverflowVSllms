required_values = [1, 2, 3]\nsome_map = [1, 2]\n\ntry:\n    next((value for value in required_values if value not in some_map), None)\nexcept StopIteration:\n    pass\nelse:\n    raise ValueError(f"Missing value: {value}")
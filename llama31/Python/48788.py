import sys\n\nmy_list = [1] * 1000\nprint(sys.getsizeof(my_list))  # Size of the list itself (references)\nprint(sys.getsizeof(1))  # Size of a single integer object
# Example in Python 2.5.2\nmy_list = [2]\nresult = my_list.extend([])  # result is None, my_list is [2]\n\n# Checking the outcomes\nprint(result == [2])  # Output: False, because None == [2] is False\nprint(result == None)  # Output: True, because None == None is True\n\n# The list itself remains unchanged\nprint(my_list)  # Output: [2]
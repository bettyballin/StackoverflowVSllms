def split_list_by_indexes(lst, indexes):\n    # Add 0 at the beginning and len(lst) at the end to handle edge cases\n    split_points = [0] + indexes + [len(lst)]\n    \n    # Use list comprehension to slice the list at each split point\n    parts = [lst[split_points[i]:split_points[i+1]] for i in range(len(split_points)-1)]\n    \n    return parts\n\nindexes = [5, 12, 17]\nmy_list = list(range(20))\nresult = split_list_by_indexes(my_list, indexes)\n\n# Print the result\nfor part in result:\n    print(part)
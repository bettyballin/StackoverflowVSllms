lst = [1, 2, 3, 4, 5]\nfor current_item, next_item in zip(lst, lst[1:]):\n    # Your comparison logic here\n    print(f"Current item: {current_item}, Next item: {next_item}")
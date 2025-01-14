def spanningsets(items):\n    if len(items) == 1:\n        # If there's only one item, it forms a single subset by itself.\n        yield [items]\n    else:\n        # Removing the last element from the list.\n        left_set, last = items[:-1], [items[-1]]\n        \n        # Recursively generate spanning sets for the rest of the items.\n        for cc in spanningsets(left_set):\n            # Add the last item as a new subset.\n            yield cc + [last]\n            \n            # Combine the last item with each existing subset in all possible ways.\n            for i, elem in enumerate(cc):\n                yield cc[:i] + [elem + last] + cc[i+1:]\n\n\n# Example usage:\nitems = [1, 2, 3, 4]\nfor ss in spanningsets(items):\n    print(ss)
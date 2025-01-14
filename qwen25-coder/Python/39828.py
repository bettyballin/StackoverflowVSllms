somelist = ['a', 'b', 'c', 'd', 'e']\nindices_to_remove = {0, 2}  # Use a set for O(1) average time complexity lookups\n\n# Create a new list excluding the specified indices\nfiltered_list = [item for index, item in enumerate(somelist) if index not in indices_to_remove]\n\nprint(filtered_list)  # Output will be ['b', 'd', 'e']
my_list = [{'id': 1, 'name': 'paul'}, {'id': 2, 'name': 'john'}]\nid_to_remove = 2\n\nmy_list = [item for item in my_list if item['id'] != id_to_remove]\n\nprint(my_list)  # Output: [{'id': 1, 'name': 'paul'}]
file_path = 'data.txt'  # Path to the text file containing the arrays\nm = get_array_from_file(file_path, 0)\nn = get_array_from_file(file_path, 1)\n\np = compare_and_create_array(m, n)\n\nprint("p[0] =", p)
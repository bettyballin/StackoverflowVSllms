def split_into_chunks(lst, chunk_size):\n    """Yield successive n-sized chunks from lst."""\n    for i in range(0, len(lst), chunk_size):\n        yield lst[i:i + chunk_size]\n\n# Example usage:\nmy_list = [1, 2, 3, 4, 5, 6, 7, 8, 9]\nchunk_size = 3\nchunks = list(split_into_chunks(my_list, chunk_size))\nprint(chunks)
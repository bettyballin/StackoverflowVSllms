def find_max_len(word_list):\n    return max(len(word) for word in word_list.split(','))\n\n# Example usage:\nprint(find_max_len("a,set,of,random,words"))  # Output: 6
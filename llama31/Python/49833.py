def seq_in_seq(needle, haystack):\n    """\n    Returns the index of the first occurrence of `needle` in `haystack`.\n    Returns -1 if `needle` is not found in `haystack`.\n    """\n    def compute_prefix_function(needle):\n        prefix = [0] * len(needle)\n        j = 0\n        for i in range(1, len(needle)):\n            while j > 0 and needle[i] != needle[j]:\n                j = prefix[j - 1]\n            if needle[i] == needle[j]:\n                j += 1\n            prefix[i] = j\n        return prefix\n\n    prefix = compute_prefix_function(needle)\n    j = 0\n    for i in range(len(haystack)):\n        while j > 0 and haystack[i] != needle[j]:\n            j = prefix[j - 1]\n        if haystack[i] == needle[j]:\n            j += 1\n        if j == len(needle):\n            return i - len(needle) + 1\n    return -1
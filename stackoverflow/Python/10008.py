def index_to_int(index):\n    s = 0\n    pow = 1\n    for letter in index[::-1]:\n        d = int(letter,36) - 9\n        s += pow * d\n        pow *= 26\n    # excel starts column numeration from 1\n    return s
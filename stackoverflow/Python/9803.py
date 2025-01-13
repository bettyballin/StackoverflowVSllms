def maxsubseq(seq):\n  # maximal sequence including the previous item\n  incl = []\n  # maximal sequence not including the previous item\n  excl = []\n\n  for i in seq:\n    # current max excluding i\n    if sum(incl) > sum(excl):\n      excl_new = incl\n    else:\n      excl_new = excl\n\n    # current max including i\n    incl = excl + [i]\n\n    excl = excl_new\n\n  if sum(incl) > sum(excl):\n    return incl\n  else:\n    return excl\n\n\nprint maxsubseq([1,4,6,3,5,7,32,2,34,34,5])
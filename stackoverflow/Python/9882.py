dict((x, set(y) & set(d1.get(x, ()))) for (x, y) in d2.iteritems())
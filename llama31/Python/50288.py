table = [['dog', 1], ['cat', 2, 'a'], ['rat', 3, 4], ['bat', 5]]\n\ndelimited_string = '\n'.join('\t'.join(map(str, row)) for row in table)\n\nprint(delimited_string)
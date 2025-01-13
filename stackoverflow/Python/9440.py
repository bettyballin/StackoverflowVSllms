#get the row with maximum number of columns\nmaxrowlen = 0\nmaxrowkey = ""\nfor timesid in d.keys():\n    if len(timesid.keys()) > maxrowlen:\n         maxrowlen = len(timesid.keys())\n         maxrowkey = timesid\nmaxrowcols = sorted(d[maxrowkey].keys())\n\n# prepare the writing\ncell_format = "%10r"    # or whatever suits your data\n\n# create the output string\nlines = []\nfor timesid in d.keys(): # go through all times\n    line = ""\n    for col in maxrowcols:  # go through the standard columns\n         colstr = ""\n         if col in d[timesid].keys():   # create an entry for each standard column\n             colstr += cell_format % d[timesid][col]  # either from actual data\n         else:\n             colstr += cell_format % ""                      # or blanks\n         line += colstr\n    lines.append(line)\n\ntext = "\n".join(lines)
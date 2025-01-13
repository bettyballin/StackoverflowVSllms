import csv\n\nf = open("my_csv_file.csv", "r")\nr = csv.DictReader(f, delimiter=',')\nfieldnames = r.fieldnames\n\ntarget = open("united.csv", 'w')\nw = csv.DictWriter(target, fieldnames=fieldnames)  # Fix: pass target instead of united\n\nwhile True:\n    try:\n        row = r.next()\n        if r.line_num <= 2:  # first two rows don't matter\n            continue\n        else:\n            w.writerow(row)\n    except StopIteration:\n        break\n\nf.close()\ntarget.close()
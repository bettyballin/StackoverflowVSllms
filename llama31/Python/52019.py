# Read the data from the file\nwith open("data.txt", "r") as f:\n    data = [line.strip().split("\t") for line in f.readlines()]\n\n# Print the data\nfor row in data:\n    print("\t".join(row))
# Define the data\ndata = [\n    ["Jessica", "Walking", "20 minutes"],\n    ["Matthew", "Run", "10 minutes"]\n]\n\n# Write the data to a file in TSV format\nwith open("data.txt", "w") as f:\n    for row in data:\n        f.write("\t".join(row) + "\n")
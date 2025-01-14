import sys\n\nif len(sys.argv) != 2:\n    print("Usage: python script.py <filename>")\n    sys.exit(1)\n\nfilename = sys.argv[1]\n\ntry:\n    with open(filename, 'r') as file:\n        content = file.read()\n        print(content)\nexcept FileNotFoundError:\n    print(f"The file {filename} does not exist.")\nexcept Exception as e:\n    print(f"An error occurred: {e}")
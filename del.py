import os

dir1 = 'sources/c_code_files_stackoverflow' 
dir2 = 'c_compiled_stackoverflow'  

# Get the list of filenames in both directories
files_dir1 = os.listdir(dir1)
files_dir2 = os.listdir(dir2)

# Remove extensions from filenames in dir1 to get base names
base_filenames_dir1 = [os.path.splitext(f)[0] for f in files_dir1]

# Identify files in dir1 that don't have corresponding base names in dir2
files_to_delete = [
    f for f in files_dir1 if os.path.splitext(f)[0] not in files_dir2
]

# Delete the files from dir1 that are not present in dir2
for f in files_to_delete:
    file_path = os.path.join(dir1, f)
    if os.path.isfile(file_path):
        os.remove(file_path)
        print(f"Deleted {file_path}")
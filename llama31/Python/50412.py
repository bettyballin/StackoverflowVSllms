import os\nimport random\n\ndir_path = 'some/directory'\nfiles = [f for f in os.listdir(dir_path) if os.path.isfile(os.path.join(dir_path, f))]\nrandom_file = random.choice(files)\npath = os.path.join(dir_path, random_file)
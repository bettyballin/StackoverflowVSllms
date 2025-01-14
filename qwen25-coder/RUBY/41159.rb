# Define the base directory\nbase_dir = '/photos'\n\n# Find all .jpg files within subdirectories of /photos\nDir.glob("#{base_dir}/**/*/*.jpg") do |file|\n  # Extract the directory path (e.g., "/photos/1/original")\n  dir_path = File.dirname(file)\n  \n  # Extract the base name of the directory (either "original" or "thumb")\n  dir_name = File.basename(dir_path)\n\n  # Set up the new file path by replacing the filename with the directory name\n  new_file_path = "#{dir_path}/#{dir_name}.jpg"\n\n  # Rename the file\n  puts "Renaming: #{file} to #{new_file_path}"\n  File.rename(file, new_file_path)\nend
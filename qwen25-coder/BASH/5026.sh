#!/bin/bash\n\n# Source directory containing your images\nsrc_dir="images"\n# Destination base directory where you want to organize the images\ndst_base="organized_images"\n\n# Ensure the destination base directory exists\nmkdir -p "$dst_base"\n\n# Iterate over each file in the source directory\nfor file in "$src_dir"/*; do\n    # Extract just the filename part, not the path\n    filename=$(basename "$file")\n    \n    # Create the destination path based on the prefix of the filename\n    dst_path="$dst_base/${filename:0:1}/${filename:1:1}/${filename:2:1}/${filename:3:1}"\n    \n    # Ensure the destination directory exists\n    mkdir -p "$dst_path"\n    \n    # Move the file to the new location\n    mv "$file" "$dst_path/$filename"\ndone\n\necho "Organizing completed!"
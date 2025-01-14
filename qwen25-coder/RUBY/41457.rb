require 'find'\n\n# Directory where your Ruby scripts are located\nbase_dir = './scripts'\n\n# Use Find to traverse all directories recursively\nFind.find(base_dir) do |path|\n  # Check if the current path is a file and ends with .rb extension\n  if File.file?(path) && path.end_with?('.rb')\n    # Execute the Ruby script using Kernel#system or backticks\n    system("ruby #{path}")\n  end\nend
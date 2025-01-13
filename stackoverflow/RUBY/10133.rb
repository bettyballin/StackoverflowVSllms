dirs = ['file1', 'dir1/file2', 'dir1/subdir1/file3',  'dir1/subdir1/file5']\ntree = {}\n\ndirs.each do |path|\n  current  = tree\n  path.split("/").inject("") do |sub_path,dir|\n    sub_path = File.join(sub_path, dir)\n    current[sub_path] ||= {}\n    current  = current[sub_path]\n    sub_path\n  end\nend\n\ndef print_tree(prefix, node)\n  puts "#{prefix}<ul>"\n  node.each_pair do |path, subtree| \n    puts "#{prefix}  <li>[#{path[1..-1]}] #{File.basename(path)}</li>"    \n    print_tree(prefix + "  ", subtree) unless subtree.empty?\n  end\n  puts "#{prefix}</ul>"\nend\n\nprint_tree "", tree
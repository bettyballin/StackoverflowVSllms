require 'mmap'\n\n# Open the file and map it into memory\nfile = File.new('your_file.txt', 'r+')\nmapping = MMap.new(file.size, MMap::PROT_READ|MMap::PROT_WRITE, nil, 0, file)\n\n# You can now access and modify the contents of the file as if it were a string\nputs mapping[0, mapping.length]\n\n# Don't forget to flush changes and close the file when done\nmapping.flush\nmapping.close\nfile.close
last_line = 0\nfile = File.open(filename, 'r+')\nfile.each {  last_line = file.pos unless file.eof? }\n\nfile.seek(last_line, IO::SEEK_SET)\n#Write your own stuff here\nfile.close
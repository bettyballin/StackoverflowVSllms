# Open the UTF-8 encoded input file\nFile.open('input.csv', 'r:UTF-8') do |file|\n  # Read the content\n  content = file.read\n  \n  # Open or create an ANSI encoded output file\n  File.open('output.csv', 'w:Windows-1252') do |out_file|\n    # Write the content with ANSI encoding\n    out_file.write(content.encode('Windows-1252'))\n  end\nend
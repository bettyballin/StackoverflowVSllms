Dir.foreach('/path/to/directory') do |file|\n  require file if File.file?("#{Dir.pwd}/#{file}")\nend
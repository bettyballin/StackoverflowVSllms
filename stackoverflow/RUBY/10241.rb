body.gsub!(/<ul>.*?<\/ul>/m) {|m| m.tr("\n",'') }
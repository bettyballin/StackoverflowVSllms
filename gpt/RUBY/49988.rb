body.gsub!(/<ul>(.*?)<\/ul>/m) do |match|\n  match.gsub("\n", "")\nend
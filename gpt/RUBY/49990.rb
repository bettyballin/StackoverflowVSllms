body = "<p>Sorry I'm really bad at regexes, I finally hacked something to work in ruby.  I'd appreciate if someone can instruct the proper way of how to do this:</p>\n\n<p>I basically wanted to remove all \n when it appears within ul tags.</p>\n\n<ul>\n<li>Item 1</li>\n<li>Item 2</li>\n<li>Item 3</li>\n</ul>\n\n<p>Thanks!</p>"\n\nbody.gsub!(/<ul>(.*?)<\/ul>/m) do |match|\n  match.gsub("\n", "")\nend\n\nputs body
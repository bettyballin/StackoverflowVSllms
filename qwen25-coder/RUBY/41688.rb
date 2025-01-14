require 'nokogiri'\nrequire 'open-uri'\n\n# Fetch the page\ndoc = Nokogiri::HTML(URI.open('http://example.com'))\n\n# Select all <a> elements with href attributes\nlinks = doc.css('a[href]')\n\n# Print the links\nlinks.each do |link|\n  puts "#{link.content} - #{link['href']}"\nend
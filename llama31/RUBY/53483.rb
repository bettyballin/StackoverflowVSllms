require 'nokogiri'\n\nhtml = File.read('your_html_file.html')\ndoc = Nokogiri::HTML(html)\n\n# Extract rows with comments\nrows = doc.xpath('//tr[preceding-sibling::comment()[contains(.,"Begin Topic Entry")]]')\n\nrows.each do |row|\n  # Extract link 1\n  link1 = row.at_xpath('.//a[@href[contains(.,"showtopic")]]/@href')\n  puts "Link 1: #{link1.text}"\n\n  # Extract description\n  description = row.at_xpath('.//span[@class="desc"]')\n  puts "Description: #{description.text}"\n\n  # Extract link 2\n  link2 = row.at_xpath('.//a[@href[contains(.,"showforum")]]/@href')\n  puts "Link 2: #{link2.text}"\nend
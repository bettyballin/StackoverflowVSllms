require 'nokogiri'\n\nhtml_content = '<html><body><p>Hello World</p></body></html>'\ndoc = Nokogiri::HTML(html_content)\nparagraph = doc.xpath('//p').text\nputs paragraph  # Output: Hello World
require 'nokogiri'\n\nvalue = Nokogiri::HTML.parse(<<-HTML_END)\n  <html>\n    <body>\n      <p id='para-1'>A</p>\n      <p id='para-22'>B</p>\n      <h1>Bla</h1>\n      <p id='para-3'>C</p>\n      <p id='para-4'>D</p>\n      <div class="foo" id="eq-1_bl-1">\n        <p id='para-5'>3</p>\n      </div>\n    </body>\n  </html>\nHTML_END\n\n# my_block is given\nmy_bl = "1"\n# my_eq corresponds to this regex\nmy_eq = "\\/[0-9]+\\/"\n\n# Using XPath with matches function\nif my_div = value.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' foo ') and matches(@id, '^eq-[0-9]+_bl-#{Regexp.escape(my_bl)}$')]").first\n  # doing some stuff with the <p> inside the div\nend
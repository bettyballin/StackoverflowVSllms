require 'nokogiri'\nrequire 'open-uri'\n\nclass HTML\n  def initialize(url)\n    @doc = Nokogiri::HTML(open(url))\n  end\n\n  def method_missing(method, *args, &block)\n    @doc.send(method, *args, &block)\n  end\nend\n\ndoc = HTML.new('http://www.google.com/search?q=tenderlove')
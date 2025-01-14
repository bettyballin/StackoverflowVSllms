require 'nokogiri'\nrequire 'open-uri'\n\nclass HTML\n  def initialize(uri = nil)\n    @uri = uri\n    @doc = parse_uri(@uri) if @uri\n  end\n\n  def parse_uri(uri)\n    Nokogiri::HTML(URI.open(uri))\n  end\n\n  def doc\n    @doc\n  end\n\n  # Example method to search within the HTML document\n  def find(selector)\n    @doc.css(selector)\n  end\nend\n\n# Usage\nhtml = HTML.new('http://www.google.com/search?q=tenderlove')\nputs html.find('title').text  # This will output the title of the page
require 'test/unit'\n\nclass HtmlTest < Test::Unit::TestCase\n  def test_html_comparison\n    expected_html = '<html><body>Hello World</body></html>'\n    actual_html = '<html> <body>Hello  World</body> </html>'\n\n    expected_html.gsub!(/\s+/, '')\n    actual_html.gsub!(/\s+/, '')\n\n    assert_equal expected_html, actual_html\n  end\nend
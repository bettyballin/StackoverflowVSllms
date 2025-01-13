module ActionView::Helpers::TagHelper\n  def tag_with_html(name, options = nil, open = true, escape = true)\n    tag_without_html(name, options, true, escape)\n  end\n  alias_method_chain :tag, :html\nend
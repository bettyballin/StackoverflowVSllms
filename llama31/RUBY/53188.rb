# Gemfile\ngem 'redcarpet'\ngem 'loofah'\n\n# ApplicationHelper\nmodule ApplicationHelper\n  def sanitize_markdown(text)\n    markdown = Redcarpet::Markdown.new(Redcarpet::Render::HTML, autolink: true, tables: true)\n    html = markdown.render(text)\n\n    Loofah.sanitize(html, {\n      tags: %w[p h1 h2 h3 h4 h5 h6 em strong a ul ol li],\n      attributes: {\n        'a' => %w[href title]\n      }\n    })\n  end\nend\n\n# Usage\nuser_input = "# Heading\n\nThis is a paragraph with [a link](http://example.com)"\nsanitized_html = sanitize_markdown(user_input)
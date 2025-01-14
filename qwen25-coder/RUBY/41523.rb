# Gemfile\ngem 'redcarpet'\ngem 'loofah'\n\n# ApplicationController or wherever you prefer\nrequire 'redcarpet'\nrequire 'loofah'\n\nmodule ApplicationHelper\n  def markdown(text)\n    # Convert Markdown to HTML\n    html = Redcarpet::Markdown.new(Redcarpet::Render::HTML).render(text)\n\n    # Sanitize the HTML output\n    Loofah.fragment(html).scrub!(:strip_tags).to_s\n  end\n\n  def sanitize_xhtml(strict_html)\n    # Define allowed tags for XHTML Strict compliance\n    sanitized = Loofah.scrub_fragment!(strict_html, :permit_scrubbing) do |whitelist|\n      whitelist.tags = %w[address bdo blockquote br button cite code col colgroup dd del dfn div dl dt em fieldset form h1 h2 h3 h4 h5 h6 ins kbd label legend li map menu noscript object ol optgroup option p param pre q samp script select small span strong sub sup table tbody td textarea tfoot th thead title tr tt ul var]\n      whitelist.attributes = %w[abbr accesskey align alt axis bgcolor class colspan dir frame headers height href lang longdesc name nowrap rel rowspan scope shape style summary tabindex title type valign width]\n    end\n    sanitized.to_s\n  end\nend\n\n# Usage in a view\n<%= sanitize_xhtml(markdown(@user_input)) %>
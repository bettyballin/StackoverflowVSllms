require 'redcloth'\nrequire 'sanitize'\n\ndef textile_and_sanitize(text)\n  # First, escape HTML tags in the input text\n  escaped_text = CGI.escapeHTML(text)\n\n  # Then, textile the escaped text\n  textiled_text = RedCloth.new(escaped_text).to_html\n\n  # Finally, sanitize the textiled text to remove any remaining XSS risks\n  sanitized_text = Sanitize.fragment(textiled_text)\n\n  sanitized_text\nend
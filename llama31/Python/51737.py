import markdown\nimport bleach\n\nmy_text = cgidata.getvalue('my_text', 'default_text')\n\n# Convert Markdown text to HTML\nhtml_text = markdown.markdown(my_text)\n\n# Sanitize the HTML output\nallowed_tags = ['p', 'em', 'strong', 'ul', 'ol', 'li', 'a']\nallowed_attributes = {'a': ['href', 'title']}\nsanitized_html = bleach.clean(html_text, tags=allowed_tags, attributes=allowed_attributes)\n\nftable.AddRow([Label(_('Enter your text')),\n               TextArea('my_text', sanitized_html, rows=8, cols=60).Format()])
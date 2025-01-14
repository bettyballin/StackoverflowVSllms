import re\n\ndef parse_custom_syntax(text):\n    # Replace custom labels with HTML tags\n    text = re.sub(r'\[bold\](.*?)\[/bold\]', r'<strong>\1</strong>', text)\n    text = re.sub(r'\[tag\](.*?)\[/tag\]', r'<span class="tag">\1</span>', text)\n    \n    # Convert Markdown to HTML (using a library like markdown2)\n    import markdown2\n    html = markdown2.markdown(text)\n    \n    return html\n\ninput_text = """\n[bold]Stackoverflow[/bold] is a [tag]good[/tag] resource for programmers.\n\n| Syntax      | Description |\n| ----------- | ----------- |\n| Header      | Title       |\n| Paragraph   | Text        |\n"""\nparsed_html = parse_custom_syntax(input_text)\nprint(parsed_html)
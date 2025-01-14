import re\n\ndef extract_text_from_html(html_content):\n    # Remove script and style elements\n    html_content = re.sub(r'<script.*?>.*?</script>', '', html_content, flags=re.DOTALL)\n    html_content = re.sub(r'<style.*?>.*?</style>', '', html_content, flags=re.DOTALL)\n\n    # Remove all HTML tags\n    text = re.sub(r'<.*?>', '', html_content)\n\n    # Remove extra whitespace\n    text = re.sub(r'\s+', ' ', text).strip()\n    \n    return text\n\nhtml_content = """\n<p>I would like to extract from a general HTML page, all the text (displayed or not).</p>\n\n<p>I would like to <strong>remove</strong> </p>\n\n<ul>\n<li>any HTML tags</li>\n<li>Any javascript</li>\n<li>Any CSS styles</li>\n</ul>\n\n<p>Is there a regular expression (one or more) that will achieve that?</p>\n"""\n\nextracted_text = extract_text_from_html(html_content)\nprint(extracted_text)
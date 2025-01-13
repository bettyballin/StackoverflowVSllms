from html5validator import Validator\n\ndef validate_html5(html_content):\n    with open('temp.html', 'w', encoding='utf-8') as f:\n        f.write(html_content)\n    \n    validator = Validator()\n    try:\n        validator.validate(['temp.html'])\n        print("HTML5 validation passed.")\n    except Exception as e:\n        print("HTML5 validation failed.")\n        print("Error: ", e)\n\nhtml_content = """<html>\n<head><title>Sample</title></head>\n<body><h1>Test</h1><p>Paragraph</p></body>\n</html>"""\n\nvalidate_html5(html_content)
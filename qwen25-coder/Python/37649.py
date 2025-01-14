from xmldiff import main\n\n# Your XML strings\nxml1 = '''<w:p>\n  <w:pPr>\n    <w:spacing w:after="1"/>\n  </w:pPr>\n  <w:r>\n    <w:t>World</w:t>\n  </w:r>\n</w:p>'''\n\nxml2 = '''<w:p>\n  <w:pPr>\n    <w:spacing w:after="1"/>\n  </w:pPr>\n  <w:r>\n    <w:t>ASDF</w:t>\n  </w:r>\n</w:p>'''\n\n# Generate diff\ndiff = main.diff_texts(xml1, xml2)\nprint(diff)\n\n# To apply the diff:\n# patched_xml = main.patch_text(xml1, diff)
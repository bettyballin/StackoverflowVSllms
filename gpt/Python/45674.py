from pdfminer.high_level import extract_pages\nfrom pdfminer.layout import LTTextBoxHorizontal, LTTextLineHorizontal\n\ndef find_offsets(pdf_path, search_string):\n    offsets = []\n    \n    for page_layout in extract_pages(pdf_path):\n        for element in page_layout:\n            if isinstance(element, LTTextBoxHorizontal):\n                for text_line in element:\n                    if isinstance(text_line, LTTextLineHorizontal):\n                        if search_string.lower() in text_line.get_text().lower():\n                            (x0, y0, x1, y1) = text_line.bbox\n                            offsets.append({\n                                'top': y1,\n                                'left': x0,\n                                'bottom': y0,\n                                'right': x1\n                            })\n    return offsets\n\n# Example usage\npdf_path = 'example.pdf'\nsearch_string = 'somestring'\noffsets = find_offsets(pdf_path, search_string)\nprint(offsets)
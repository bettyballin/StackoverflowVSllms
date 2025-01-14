import fitz  # PyMuPDF\n\ndef find_offsets(pdf_path, search_string):\n    doc = fitz.open(pdf_path)\n    highlights = []\n\n    for page_num in range(len(doc)):\n        page = doc.load_page(page_num)  # number pages from 0\n        text_instances = page.search_for(search_string)\n\n        for inst in text_instances:\n            # rect is a tuple of (left, top, right, bottom) positions\n            highlights.append({\n                'page': page_num,\n                'top': inst.y0,\n                'bottom': inst.y1,\n                'left': inst.x0,\n                'right': inst.x1,\n            })\n\n    return highlights\n\n# Example usage:\npdf_path = 'example.pdf'\nsearch_string = 'somestring'\noffsets = find_offsets(pdf_path, search_string)\nprint(offsets)
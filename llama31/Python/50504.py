tree = etree.parse(StringIO(doc))\nnsmap = {'xhtml': 'http://www.w3.org/1999/xhtml'}\nimg_element = tree.getroot().xpath('//xhtml:img', nsmap=nsmap)
import uritemplate\n\ndef get_item(request, service_name, item_id):\n    doc = etree.parse(urllib.urlopen('http://example.com/services/'))\n    item_link = doc.xpath("service/name[.='%s']/following-sibling::item_link" % service_name)[0].text\n    item_uri = uritemplate.expand(item_link, {'item_id': item_id})\n    # Perform the request to retrieve the item\n    item_doc = etree.parse(urllib.urlopen(item_uri))\n    # Process the item document\n    ...
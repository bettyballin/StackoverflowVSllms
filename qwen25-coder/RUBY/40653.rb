require 'rexml/document'\n\ndoc = REXML::Document.new <<-XML\n  <root>\n    <p>hello <span>world</span> a </p>\n    <p>Hi there </p>\n    <p>The End </p>\n  </root>\nXML\n\n# Select all paragraph elements under the root node\nparagraphs = REXML::XPath.match(doc, "//root/p")\n\nparagraphs.each do |para|\n  # Get all text nodes that are direct children of the paragraph\n  text_nodes = para.get_elements("text()").compact\n  \n  if text_nodes.any?\n    # Trim the last text node\n    last_text_node = text_nodes.last\n    last_text_node.replace(last_text_node.text.rstrip)\n  end\nend\n\n# Output the modified XML\nputs doc.to_s
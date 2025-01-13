import gnomecanvas\n\n# Create a new canvas\ncanvas = gnomecanvas.Canvas()\n\n# Create a new text item\ntext_item = canvas.text(10, 10, "Hello, World!")\n\n# Set the justification property to align the text to the right\ntext_item.set_property("justification", gnomecanvas.JUSTIFY_RIGHT)\n\n# Set the anchor property to the right side of the bounding box\ntext_item.set_property("anchor", gnomecanvas.ANCHOR_EAST)\n\n# Show the canvas\ncanvas.show()
import gtk\n\ndef on_enter_key(widget, event, textbuffer):\n    if event.keyval == gtk.keysyms.Return:\n        start_iter = textbuffer.get_start_iter()\n        end_iter = textbuffer.get_end_iter()\n        textbuffer.delete(start_iter, end_iter)\n        return True  # Prevent the default handler from being executed\n\n# Create a TextView and TextBuffer\ntextview = gtk.TextView()\ntextbuffer = textview.get_buffer()\n\n# Connect the key-press-event to the handler\ntextview.connect("key-press-event", on_enter_key, textbuffer)\n\n# Create a window and add the TextView\nwindow = gtk.Window()\nwindow.add(textview)\nwindow.show_all()\n\ngtk.main()
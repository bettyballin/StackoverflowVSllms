import gtk\n\ndef clear_buffer(buffer):\n    buffer.set_text("")\n    iter = buffer.get_iter_at_offset(0)\n    buffer.delete(iter, buffer.get_end_iter())\n\n# assume 'buffer' is your gtk.TextBuffer\nbuffer.connect("insert-text", lambda buffer, iter, text, len: clear_buffer(buffer) if text == "\n" else None)
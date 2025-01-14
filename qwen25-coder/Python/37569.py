from gi.repository import Gtk, Gdk\n\ndef on_key_press(buffer, event):\n    key = event.get_keyval()[1]\n    if key == Gdk.KEY_Return:\n        start_iter = buffer.get_start_iter()\n        end_iter = buffer.get_end_iter()\n\n        # Get the text from the buffer and strip any newline characters\n        current_text = buffer.get_text(start_iter, end_iter, True).strip('\n')\n        \n        # Clear the buffer and set it with stripped text\n        buffer.set_text(current_text, -1)\n\n# Example usage in a Gtk.Window\nclass SimpleTextEditor(Gtk.Window):\n    def __init__(self):\n        super().__init__()\n        self.set_default_size(300, 200)\n        self.textview = Gtk.TextView()\n        self.buffer = self.textview.get_buffer()\n\n        # Connect the key-press-event signal to on_key_press\n        self.textview.connect("key-press-event", on_key_press)\n\n        self.add(self.textview)\n\nwin = SimpleTextEditor()\nwin.connect("destroy", Gtk.main_quit)\nwin.show_all()\nGtk.main()
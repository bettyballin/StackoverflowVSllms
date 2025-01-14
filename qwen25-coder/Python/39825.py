import gi\ngi.require_version('Gtk', '3.0')\nfrom gi.repository import Gtk, Gdk\n\nclass MyWindow(Gtk.Window):\n    def __init__(self):\n        super().__init__(title="Resize Detector")\n        self.set_default_size(400, 300)\n        self.connect("configure-event", self.on_configure_event)\n\n    def on_configure_event(self, widget, event):\n        # Check if the event is caused by user interaction\n        if event.send_event:\n            print(f"Window resized to {event.width}x{event.height}")\n\ndef main():\n    window = MyWindow()\n    window.connect("destroy", Gtk.main_quit)\n    window.show_all()\n    Gtk.main()\n\nif __name__ == "__main__":\n    main()
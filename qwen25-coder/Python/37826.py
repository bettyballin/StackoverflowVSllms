import gi\ngi.require_version('Gtk', '3.0')\nfrom gi.repository import Gtk, GLib\n\nclass MyWindow(Gtk.Window):\n    def __init__(self):\n        super().__init__(title="Timed Disable Button")\n        \n        self.vbox = Gtk.VBox()\n        \n        # Create a dialog with an OK button\n        self.dialog = Gtk.Dialog(\n            "Please wait",\n            self,\n            0,\n            (Gtk.STOCK_CANCEL, Gtk.ResponseType.CANCEL)\n        )\n        ok_button = self.dialog.add_button("OK", Gtk.ResponseType.OK)\n        ok_button.set_sensitive(False)  # Disable the button initially\n        \n        label = Gtk.Label(label="This button will be enabled in 5 seconds.")\n        self.dialog.vbox.pack_start(label, True, True, 0)\n        \n        # Show all dialog elements\n        self.dialog.show_all()\n        \n        # Set up a timer to enable the OK button after 5 seconds\n        GLib.timeout_add_seconds(5, self.enable_ok_button, ok_button)\n\n    def enable_ok_button(self, button):\n        button.set_sensitive(True)\n        return False  # Remove the timeout handler\n\ndef main():\n    win = MyWindow()\n    win.connect("destroy", Gtk.main_quit)\n    win.show_all()\n    Gtk.main()\n\nif __name__ == "__main__":\n    main()
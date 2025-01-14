import gi\ngi.require_version('Gtk', '3.0')\nfrom gi.repository import Gtk\n\nclass MyWindow(Gtk.Window):\n    def __init__(self):\n        super(MyWindow, self).__init__(title="Glade Example")\n\n        # Load glade file\n        builder = Gtk.Builder()\n        builder.add_from_file("yourfile.glade")\n        \n        # Connect signals if needed\n        builder.connect_signals(self)\n        \n        # Get the main window from the Glade file\n        self.add(builder.get_object("main_window"))\n\n    def on_button_clicked(self, button):\n        print("Button has been clicked!")\n\nwin = MyWindow()\nwin.connect("destroy", Gtk.main_quit)\nwin.show_all()\nGtk.main()
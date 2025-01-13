import gi\ngi.require_version('Gtk', '3.0')\nfrom gi.repository import Gtk, Gio\n\nclass MyWindow(Gtk.Window):\n    def __init__(self):\n        Gtk.Window.__init__(self, title="Colored Button Example")\n        \n        # Load the CSS\n        css_provider = Gtk.CssProvider()\n        css_provider.load_from_path('style.css')\n        \n        screen = Gdk.Screen.get_default()\n        style_context = Gtk.StyleContext()\n        style_context.add_provider_for_screen(screen, css_provider, Gtk.STYLE_PROVIDER_PRIORITY_USER)\n        \n        # Create a button\n        button = Gtk.Button(label="Click Me")\n        \n        # Add button to the window\n        self.add(button)\n\nwin = MyWindow()\nwin.connect("destroy", Gtk.main_quit)\nwin.show_all()\nGtk.main()
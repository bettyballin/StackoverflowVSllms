class TestClass:\n    def __init__(self):\n        self.wTree = gtk.glade.XML("test.glade")\n        self.connect_signals()\n\n    def connect_signals(self):\n        self.wTree.signal_autoconnect(self)\n\n    def on_TestClass_destroy(self, widget, data):\n        gtk.main_quit()
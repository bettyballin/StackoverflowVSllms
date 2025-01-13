import gtk\nimport gobject\n\nclass MyApp:\n    def __init__(self):\n        builder = gtk.Builder()\n        builder.add_from_file("your_glade_file.glade")\n        self.tracked_interface = builder.get_object("tracked_interface")\n\n        # Create a ListStore with one string column to use as the model\n        self.iface_list_store = gtk.ListStore(gobject.TYPE_STRING)\n\n        # Add items to the ListStore\n        self.iface_list_store.append(["hello, "])\n        self.iface_list_store.append(["world."])\n\n        # Set the model for the ComboBox\n        self.tracked_interface.set_model(self.iface_list_store)\n\n        # Create a CellRendererText and pack it into the ComboBox\n        renderer_text = gtk.CellRendererText()\n        self.tracked_interface.pack_start(renderer_text, True)\n        self.tracked_interface.add_attribute(renderer_text, "text", 0)\n\n        # Set the active item\n        self.tracked_interface.set_active(0)\n\nif __name__ == "__main__":\n    MyApp()\n    gtk.main()
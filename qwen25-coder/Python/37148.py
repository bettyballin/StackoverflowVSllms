import gtk\nimport gobject\n\n# Assuming builder is your GtkBuilder object and has loaded the UI file\nself.tracked_interface = builder.get_object("tracked_interface")\n\n# Create a ListStore to hold the interface names\nself.iface_list_store = gtk.ListStore(gobject.TYPE_STRING)\n\n# Append some sample data\nself.iface_list_store.append(["hello, "])\nself.iface_list_store.append(["world."])\n\n# Set the model of the ComboBox to the ListStore\nself.tracked_interface.set_model(self.iface_list_store)\n\n# Create a CellRendererText and pack it into the ComboBox\ncell = gtk.CellRendererText()\nself.tracked_interface.pack_start(cell, True)\nself.tracked_interface.add_attribute(cell, 'text', 0)  # Assuming column 0 holds the text\n\n# Set the default active item (first item in this case)\nself.tracked_interface.set_active(0)
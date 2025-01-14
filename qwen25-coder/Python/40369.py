from gi.repository import Gtk\n\n# Create the model\nstore = Gtk.ListStore(str, str, str, str)\n\n# Create the tree view\ntree_view = Gtk.TreeView(model=store)\n\n# Create columns\nrenderer_text = Gtk.CellRendererText()\ncolumn0 = Gtk.TreeViewColumn("Column 1", renderer_text, text=0)\ncolumn1 = Gtk.TreeViewColumn("Column 2", renderer_text, text=1)\ncolumn2 = Gtk.TreeViewColumn("Column 3", renderer_text, text=2)\ncolumn3 = Gtk.TreeViewColumn("Column 4", renderer_text, text=3)\n\n# Set fixed width for column 0 and 1\ncolumn0.set_fixed_width(150)  # Adjust the size according to your needs\ncolumn1.set_fixed_width(200)\n\n# Allow column 2 and 3 to expand and fill remaining space\ncolumn2.set_expand(True)\ncolumn3.set_expand(True)\n\n# Add columns to tree view\ntree_view.append_column(column0)\ntree_view.append_column(column1)\ntree_view.append_column(column2)\ntree_view.append_column(column3)\n\n# Example window setup\nwindow = Gtk.Window()\nwindow.connect("destroy", Gtk.main_quit)\nwindow.add(tree_view)\nwindow.show_all()\n\nGtk.main()
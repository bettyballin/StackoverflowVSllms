class MyDialog(gtk.Dialog, gtk.Buildable):\n    __gtype_name__ = "MyDialog"\n\n    def do_parser_finished(self, builder):\n        self.treeview = builder.get_object("treeview1")\n        # Do any other associated post-initializatio
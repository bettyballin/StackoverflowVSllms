import gtk\nimport gtk.glade\n\ndef on_window1_focus_in_event(widget, event):\n    widget.child_focus(gtk.DIR_TAB_FORWARD)\n    return False\n\nwindow_tree = gtk.glade.XML('testtoolbar.glade')\nwindow = window_tree.get_widget('window1')\nwindow.connect('focus-in-event', on_window1_focus_in_event)\n\ngtk.main()
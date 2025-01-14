import pygtk\npygtk.require('2.0')\nimport gtk\n\ndef drop_cb(wid, context, x, y, time):\n    # Request the data with the target type that indicates text/uri-list (URLs)\n    wid.drag_get_data(context, context.targets[0], time)\n\ndef on_drag_data_received(wid, context, x, y, selection, info, time):\n    # Extract the URL from the selection data\n    url = selection.data.strip().decode('utf-8')\n    print(f"Received URL: {url}")\n    l.set_text(url)\n    \n    # Here you would save the URL to the database\n    save_url_to_database(url)\n    \n    context.finish(True, False, time)\n\ndef save_url_to_database(url):\n    # Dummy function to simulate saving the URL to a database\n    print(f"Saving URL to database: {url}")\n\n# Create a GTK window and Label, and hook up drag n drop signal handlers to the window\nw = gtk.Window()\nw.set_size_request(200, 150)\nw.drag_dest_set(gtk.DEST_DEFAULT_ALL, [], gtk.gdk.ACTION_COPY)\nw.connect('drag_drop', drop_cb)\nw.connect('drag_data_received', on_drag_data_received)\nw.connect('destroy', lambda w: gtk.main_quit())\n\n# Specify the target types we accept (text/uri-list for URLs)\ntarget = [('text/uri-list', 0, 0)]\nw.drag_dest_set_target_list(gtk.target_list_new(target))\n\nl = gtk.Label()\nw.add(l)\nw.show_all()\n\n# Start the program\ngtk.main()
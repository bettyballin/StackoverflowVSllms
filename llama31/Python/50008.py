self.image = gtk.gdk.pixbuf_new_from_file("image.png")\nself.image = self.image.add_alpha(True, 0xff, 0xff, 0xff)  # add alpha channel\nself.image = self.image.convert_colorspace(gtk.gdk.COLORSPACE_RGB, gtk.gdk.PIXEL_FORMAT_for_DISPLAY(self.drawing_area.window))\nself.pixmap.draw_pixbuf(self.gc, self.image, 0, 0, 0, 0)
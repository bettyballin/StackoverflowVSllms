import gtk\nfrom gi.repository import GdkPixbuf, Gdk\n\nclass NetworkAnimator:\n    def __init__(self, drawing_area):\n        self.drawing_area = drawing_area\n        self.t = 0.0  # Initialize time step\n\n    def draw(self):\n        rect = self.drawing_area.get_allocation()\n        pixbuf = GdkPixbuf.Pixbuf.new(GdkPixbuf.Colorspace.RGB, True, 8, rect.width, rect.height)\n        gc = pixbuf.get_colormap().new_gc(source=Gdk.color_parse("#FFFFFF"))\n        \n        # Fill the background\n        pixbuf.fill(0xFFFFFFFF)  # Solid white background\n\n        # Draw nodes\n        pos = [n.position_at(self.t) for n in self.nodes]\n        NODE_SIZE = 10  # Example node size\n\n        cairo = Gdk.cairo_create(pixbuf)\n        for p in pos:\n            x = rect.width * (p.x / 2400.0) - NODE_SIZE / 2\n            y = rect.height * (p.y / 2400.0) - NODE_SIZE / 2\n            cairo.arc(x, y, NODE_SIZE / 2, 0, 2 * 3.14)\n            cairo.fill()\n\n        # Flush and draw the pixbuf to the drawing area\n        gc.set_clip_rectangle(rect)\n        self.drawing_area.window.draw_pixbuf(gc, pixbuf, src_x=0, src_y=0, dest_x=0, dest_y=0, width=-1, height=-1)\n\n    def update(self):\n        self.t += 0.1  # Increment time\n        self.draw()\n\n# Usage example:\ndef main():\n    win = gtk.Window()\n    da = gtk.DrawingArea()\n    anim = NetworkAnimator(da)\n    \n    def expose_event(widget, event):\n        anim.draw()\n    \n    def timeout_update():\n        anim.update()\n        return True\n    \n    da.connect("expose-event", expose_event)\n    win.add(da)\n    win.show_all()\n\n    import gobject\n    gobject.timeout_add(100, timeout_update)  # Update every 100ms\n\n    gtk.main()\n\nif __name__ == "__main__":\n    main()
def __init__(self):\n    self.drawing_area = gtk.DrawingArea()\n    self.pixmap = gtk.gdk.Pixmap(self.drawing_area.window, width, height, depth=gtk.gdk.visual_get_system().depth)\n\ndef area_expose_cb(self, area, event):\n    self.drawing_area.window.copy_area(self.pixmap, self.gc, 0, 0, x, y, width, height)
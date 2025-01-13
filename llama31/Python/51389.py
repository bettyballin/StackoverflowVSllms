import gobject\n\nclass MyObject(gobject.GObject):\n    __gsignals__ = {\n        'my_signal': (gobject.SIGNAL_RUN_FIRST, gobject.TYPE_NONE, (gobject.TYPE_STRING,))\n    }\n\n    def __init__(self):\n        gobject.GObject.__init__(self)\n\n    def emit_my_signal(self, message):\n        self.emit('my_signal', message)\n\n# Create an instance of MyObject\nobj = MyObject()\n\n# Connect to the signal\ndef callback(obj, message):\n    print("Received signal with message:", message)\n\nobj.connect('my_signal', callback)\n\n# Emit the signal\nobj.emit_my_signal("Hello, World!")
import sys\nfrom PyQt5.QtCore import Qt\nfrom PyQt5.QtGui import QImage, QPainter\nfrom PyQt5.QtWidgets import QWidget, QApplication\nimport cairo\n\nclass CairoSurface(QWidget):\n    def __init__(self):\n        super().__init__()\n\n        self.surface = cairo.ImageSurface(cairo.FORMAT_ARGB32, 400, 400)\n        self.context = cairo.Context(self.surface)\n\n        self.context.set_source_rgb(1, 1, 1)\n        self.context.paint()\n\n        self.context.set_source_rgb(0, 0, 0)\n        self.context.rectangle(50, 50, 200, 200)\n        self.context.fill()\n\n    def paintEvent(self, event):\n        qp = QPainter()\n        qp.begin(self)\n        image = QImage(self.surface.get_data(), 400, 400, QImage.Format_ARGB32)\n        qp.drawImage(0, 0, image)\n        qp.end()\n\nif __name__ == '__main__':\n    app = QApplication(sys.argv)\n    ex = CairoSurface()\n    ex.resize(400, 400)\n    ex.show()\n    sys.exit(app.exec_())
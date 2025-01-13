import sys\nfrom PyQt5.QtWidgets import QApplication, QGraphicsView, QGraphicsScene\nfrom PyQt5.QtGui import QPainter, QPen, QBrush\nfrom PyQt5.QtCore import Qt\n\nclass ZoomableCanvas(QGraphicsView):\n    def __init__(self):\n        super().__init__()\n        self.scene = QGraphicsScene()\n        self.setScene(self.scene)\n\n        # Create some sample widgets\n        self.scene.addEllipse(10, 10, 50, 50)\n        self.scene.addText("Hello, World!")\n\n        # Enable zooming\n        self.setTransformationAnchor(QGraphicsView.AnchorUnderMouse)\n        self.setDragMode(QGraphicsView.ScrollHandDrag)\n\n    def wheelEvent(self, event):\n        angle = event.angleDelta().y()\n        factor = 1.2 if angle > 0 else 1 / 1.2\n        self.scale(factor, factor)\n\nif __name__ == "__main__":\n    app = QApplication(sys.argv)\n    canvas = ZoomableCanvas()\n    canvas.show()\n    sys.exit(app.exec_())
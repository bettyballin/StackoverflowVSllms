def positionChanged(self, newPos):\n    self.snappedPos = snapToGrid(newPos, Y_OFFSET, Y_STEP)
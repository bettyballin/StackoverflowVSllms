Application.DoEvents()\nThread.Sleep(10) ' Adding a small delay\n\nDim labelRelativePosition As Point = Me.PointToClient(Label1.Parent.PointToScreen(Label1.Location))
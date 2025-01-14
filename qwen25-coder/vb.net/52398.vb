Imports System.Drawing\nImports System.Windows.Forms\n\nPublic Sub CreateRoundedRectangle(pictureBox As PictureBox, width As Integer, height As Integer, radius As Integer)\n    ' Create a bitmap with the specified dimensions.\n    Using bmp As New Bitmap(width, height)\n        ' Initialize graphics from the defined bitmap.\n        Using g As Graphics = Graphics.FromImage(bmp)\n            ' Set the smoothing mode to anti-aliasing for smooth corners.\n            g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias\n\n            ' Define a rectangle with rounded corners.\n            Dim rect As New RectangleF(0, 0, width - 1, height - 1)\n            Dim path As New GraphicsPath()\n            path.AddArc(rect.X, rect.Y, radius * 2, radius * 2, 180, 90) ' Top-left corner.\n            path.AddArc(rect.Width - radius * 2, rect.Y, radius * 2, radius * 2, 270, 90) ' Top-right corner.\n            path.AddArc(rect.Width - radius * 2, rect.Height - radius * 2, radius * 2, radius * 2, 0, 90) ' Bottom-right corner.\n            path.AddArc(rect.X, rect.Height - radius * 2, radius * 2, radius * 2, 90, 90) ' Bottom-left corner.\n            path.CloseFigure()\n\n            ' Fill the rounded rectangle with a solid color, e.g., Blue.\n            Using brush As New SolidBrush(Color.Blue)\n                g.FillPath(brush, path)\n            End Using\n        End Using\n\n        ' Assign the bitmap to the PictureBox control.\n        pictureBox.Image = bmp\n    End Using\n\n    ' Make sure the PictureBox is visible and set its size accordingly.\n    pictureBox.Visible = True\n    pictureBox.Width = width\n    pictureBox.Height = height\nEnd Sub
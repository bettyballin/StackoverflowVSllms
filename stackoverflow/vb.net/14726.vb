Private Sub PictureBox1_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox1.MouseMove\n   Using graphFun As Graphics = Graphics.FromImage(Image)\n      If BoolErasing Then\n         GraphFun.DrawLine(ErasingPen, Xstart, Ystart, e.X, e.Y)\n      ElseIf BoolDrawing Then\n         GraphFun.DrawLine(DrawingPen, Xstart, Ystart, e.X, e.Y)\n      End If\n   End Using\n   Xstart = e.X\n   Ystart = e.Y\n   PictureBox1.Image = Image\nEnd Sub
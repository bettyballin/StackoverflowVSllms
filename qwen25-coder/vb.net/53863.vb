Dim stream As New System.IO.MemoryStream() ' Assuming 'stream' contains your EMF data\nUsing img As New System.Drawing.Imaging.Metafile(stream)\n    Dim bitmap As New Bitmap(img.Width, img.Height) ' Create a new bitmap with the same dimensions\n\n    Using g As Graphics = Graphics.FromImage(bitmap)\n        g.Clear(Color.Transparent) ' Clear with transparent background\n        g.DrawImage(img, 0, 0, img.Width, img.Height) ' Draw metafile onto the bitmap\n    End Using\n\n    bitmap.Save(Server.MapPath("/FileName.gif"), System.Drawing.Imaging.ImageFormat.Gif)\nEnd Using
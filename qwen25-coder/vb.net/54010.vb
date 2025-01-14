Imports System.Drawing\n\nPublic Sub RotatePictureBox(pictureBox As PictureBox)\n    ' Load the image from the PictureBox\n    Using originalImage = DirectCast(pictureBox.Image, Bitmap)\n        If originalImage IsNot Nothing Then\n            ' Create a new bitmap to hold rotated image\n            Using rotatedBmp = New Bitmap(originalImage.Width, originalImage.Height)\n                Using g = Graphics.FromImage(rotatedBmp)\n                    ' Move the rotation point to the center of the image\n                    g.TranslateTransform(originalImage.Width \ 2, originalImage.Height \ 2)\n\n                    ' Rotate by 180 degrees\n                    g.RotateTransform(180)\n\n                    ' Move image back\n                    g.TranslateTransform(-originalImage.Width \ 2, -originalImage.Height \ 2)\n\n                    ' Draw the original image onto the new bitmap.\n                    g.DrawImage(originalImage, New Point(0, 0))\n                End Using\n\n                ' Set the PictureBox to display the rotated image\n                pictureBox.Image = DirectCast(rotatedBmp.Clone(), Bitmap)\n            End Using\n        End If\n    End Using\nEnd Sub
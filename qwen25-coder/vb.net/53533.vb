' Assuming 'btn' is your dynamically created button and 'imagePath' is the path to your image.\nTry\n    ' Load the image from the specified path\n    Dim img As New Image(Imaging.Image.FromFile(imagePath))\n\n    ' Set the image of the button\n    btn.Image = img\n\n    ' Hide the text on the button\n    btn.Text = ""\n\nCatch ex As Exception\n    MessageBox.Show("Error loading image: " & ex.Message)\nEnd Try
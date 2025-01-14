Imports System.Data.SqlClient\nImports System.IO\nImports System.Drawing\n\nPublic Function GetImageSizeFromDatabase(imageData As Byte()) As Size\n    ' Load image from byte array\n    Using ms As New MemoryStream(imageData)\n        Dim img As Image = Image.FromStream(ms)\n        Return img.Size\n    End Using\nEnd Function\n\n' Usage example within your code where you get imageData from the database:\nDim connectionString As String = "your_connection_string_here"\nUsing connection As New SqlConnection(connectionString)\n    connection.Open()\n    Dim query As String = "SELECT imageData FROM YourTable WHERE SomeCondition = @Condition"\n    Using command As New SqlCommand(query, connection)\n        command.Parameters.AddWithValue("@Condition", yourConditionValue)\n        \n        Dim imageData As Byte() = DirectCast(command.ExecuteScalar(), Byte())\n        If imageData IsNot Nothing Then\n            Dim imageSize As Size = GetImageSizeFromDatabase(imageData)\n            ' Set PictureBox dimensions based on image size\n            YourPictureBox.Width = imageSize.Width\n            YourPictureBox.Height = imageSize.Height\n        End If\n    End Using\nEnd Using
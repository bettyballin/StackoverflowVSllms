Protected Sub btnUpload_Click(ByVal sender As Object, ByVal e As EventArgs) Handles btnUpload.Click\n    If FileUpload1.HasFile Then\n        Dim postedFile As HttpPostedFile = FileUpload1.PostedFile\n        Dim fileSize As Integer = postedFile.ContentLength\n\n        ' Check if the file size is greater than 1MB (1MB = 1048576 bytes)\n        If fileSize > 1048576 Then\n            lblMessage.Text = "The file size should not be greater than 1MB."\n        Else\n            ' Save the uploaded file\n            Dim filePath As String = Server.MapPath("~/Uploads/") + Path.GetFileName(postedFile.FileName)\n            postedFile.SaveAs(filePath)\n            lblMessage.Text = "File uploaded successfully."\n        End If\n    Else\n        lblMessage.Text = "Please select a file to upload."\n    End If\nEnd Sub
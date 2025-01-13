protected void UploadButton_Click(object sender, EventArgs e)\n{\n    if (FileUpload1.HasFile)\n    {\n        try\n        {\n            string filename = Path.GetFileName(FileUpload1.FileName);\n            FileUpload1.SaveAs(Server.MapPath("~/Uploads/") + filename);\n            UploadStatusLabel.Text = "File uploaded successfully!";\n        }\n        catch (Exception ex)\n        {\n            UploadStatusLabel.Text = "File upload failed: " + ex.Message;\n        }\n    }\n    else\n    {\n        UploadStatusLabel.Text = "No file selected.";\n    }\n}
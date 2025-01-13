protected void Page_Load(object sender, EventArgs e)\n{\n    string directoryPath = Server.MapPath("~/images/"); // Path to images folder\n    string fileNameWithoutExtension = "myimage"; // Name of the image file without extension\n\n    string imagePath = FindImageFile(directoryPath, fileNameWithoutExtension);\n    if (imagePath != null)\n    {\n        Image1.ImageUrl = "~/images/" + Path.GetFileName(imagePath); // Set the Image control Url\n    }\n    else\n    {\n        // Handle the error: no image file found\n        LabelError.Text = "Image not found.";\n    }\n}
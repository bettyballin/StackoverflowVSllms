protected void ChangeLogoButton_Click(object sender, EventArgs e)\n{\n    string newImagePath = "Pics/Image123.jpg";\n    string uniqueImageUrl = newImagePath + "?v=" + DateTime.Now.Ticks;\n    ImageControl.ImageUrl = uniqueImageUrl;\n}
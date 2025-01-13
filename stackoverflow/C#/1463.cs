private void button1_Click(object sender, EventArgs e)\n{\n    string apikey = "3f8554b23a5we2fe2c7asdg80agnkdm9cedag415f34d9fb";\n    Flickr F = new Flickr(apikey);\n\n\n    // Example 2\n    PhotoSearchOptions searchOptions = new PhotoSearchOptions();\n    searchOptions.Tags = textBox1.Text;\n    searchOptions.PerPage = 100;\n    Photos microsoftPhotos = F.PhotosSearch(searchOptions);\n\n    // Example 3\n    searchOptions.Page = 2;\n    Photos microsoftPhotos2 = F.PhotosSearch(searchOptions);\n    searchOptions.Page = 3;\n    Photos microsoftPhotos3 = F.PhotosSearch(searchOptions);\n\n    // Eample 4\n    PhotoCollection allPhotos = microsoftPhotos.PhotoCollection;\n    allPhotos.AddRange(microsoftPhotos2.PhotoCollection);\n    allPhotos.AddRange(microsoftPhotos3.PhotoCollection);\n\n\n    progressBar1.Maximum = allPhotos.Count;\n    progressBar1.Value = 0;\n\n\n    foreach (Photo p in allPhotos)\n    {\n        pictureBox1.Image = Image.FromStream(F.DownloadPicture(p.MediumUrl));\n\n        this.Refresh();\n\n        progressBar1.Value++;\n    }\n}
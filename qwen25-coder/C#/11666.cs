// Assuming you are setting the ImageUrl property for an ASP.Net Web Forms Image control\nprotected void SetUserImage()\n{\n    string sessionId = Session["userID"] as string;\n    string imageUrl = $"~/ImageHandler.ashx?user={sessionId}&timestamp={DateTime.Now.Ticks}";\n    MyImageControl.ImageUrl = imageUrl;\n}
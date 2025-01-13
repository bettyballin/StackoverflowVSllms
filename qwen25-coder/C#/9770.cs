protected void btnLogin_Click(object sender, EventArgs e)\n{\n    if (IsValidUser(txtUsername.Text, txtPassword.Text)) // Replace with your validation logic\n    {\n        // Check if there's a last visited page stored in session and redirect.\n        string lastVisitedPage = Session["LastVisitedPage"] as string;\n        if (!string.IsNullOrEmpty(lastVisitedPage))\n        {\n            Response.Redirect(lastVisitedPage);\n        }\n        else\n        {\n            Response.Redirect("Default.aspx");\n        }\n    }\n}
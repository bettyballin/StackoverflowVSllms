protected void SubmitButton_Click(object sender, EventArgs e)\n{\n    // Validate all validators on the page\n    if (Page.IsValid)\n    {\n        // Your code to proceed when validation is successful\n        Response.Redirect("NextPage.aspx");\n    }\n    else\n    {\n        // Handle invalid case. In this simple example, you might just display an error message or take other actions.\n    }\n}
// Back button click event handler\nprotected void btnBack_Click(object sender, EventArgs e)\n{\n    string orderId = Request.QueryString["OrderId"];\n    Response.Redirect("PageA.aspx?OrderId=" + orderId);\n}
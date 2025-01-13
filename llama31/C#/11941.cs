protected void btnDelete_Click(object sender, EventArgs e)\n{\n    ScriptManager.RegisterStartupScript(this, this.GetType(), "confirm", "confirmDelete();", true);\n    // Because of the async nature, you might want to handle the deletion logic in a different method\n    // Here we assume that we proceed with deletion based on hfConfirm value\n    // You might need to adapt this logic to fit your exact requirements\n    if (hfConfirm.Value == "Yes")\n    {\n        // Code to delete the record\n    }\n    else\n    {\n        // Do not delete the record, optionally display a message\n    }\n}
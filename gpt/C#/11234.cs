// In LaunchPage.aspx.cs\n   protected void RedirectToDataEntry(object sender, EventArgs e)\n   {\n       string patientId = txtPatientId.Text;\n       Response.Redirect($"https://dataentryapp.com?patientId={patientId}");\n   }\n\n   protected void RedirectToAssessment(object sender, EventArgs e)\n   {\n       string patientId = txtPatientId.Text;\n       Response.Redirect($"https://assessmentapp.com?patientId={patientId}");\n   }
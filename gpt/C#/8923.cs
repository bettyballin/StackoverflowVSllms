protected void SubmitButton_Click(object sender, EventArgs e) {\n    foreach (RepeaterItem item in Repeater1.Items) {\n        TextBox txtAnswer = (TextBox)item.FindControl("txtAnswer");\n        int questionNumber = (int)DataBinder.Eval(item.DataItem, "QuestionNumber");\n        \n        // Update the ObjectDataSource with new values\n        var parameters = new Dictionary<string, object>\n        {\n            { "QuestionNumber", questionNumber },\n            { "Answer", txtAnswer.Text }\n        };\n\n        QuestionDataSource.UpdateParameters.Clear();\n        foreach (var param in parameters)\n        {\n            QuestionDataSource.UpdateParameters.Add(param.Key, param.Value.ToString());\n        }\n\n        QuestionDataSource.Update();\n    }\n}
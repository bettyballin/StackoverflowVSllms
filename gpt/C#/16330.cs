// Update game count label \npublic void maxGameCountLblUpdate(decimal maxGames)\n{\n    maxGames = decimal.ToInt32(maxGames);\n\n    if (myGameCountLbl != null)\n    {\n        myGameCountLbl.Text = maxGames.ToString();\n    }\n    else\n    {\n        // Handle the case where myGameCountLbl is null\n        MessageBox.Show("myGameCountLbl is not initialized.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);\n    }\n\n    if (compGameCountLbl != null)\n    {\n        compGameCountLbl.Text = maxGames.ToString();\n    }\n    else\n    {\n        // Handle the case where compGameCountLbl is null\n        MessageBox.Show("compGameCountLbl is not initialized.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);\n    }\n}
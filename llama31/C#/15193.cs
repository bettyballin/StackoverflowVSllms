private void textBox1_KeyUp(object sender, EventArgs e)\n{\n    string yourSentence = textBox1.Text.ToLower().Trim();\n\n    int counta = 0;\n    int counte = 0;\n    int counti = 0;\n    int counto = 0;\n    int countu = 0;\n\n    foreach (char v in yourSentence)\n    {\n        if (v == 'a') { counta++; }\n        else if (v == 'e') { counte++; }\n        else if (v == 'i') { counti++; }\n        else if (v == 'o') { counto++; }\n        else if (v == 'u') { countu++; }\n    }\n\n    listBox1.Items.Clear();\n    listBox1.Items.Add("There are " + counta.ToString().Trim() + " a's in the sentence");\n    listBox1.Items.Add("There are " + counte.ToString().Trim() + " e's in the sentence");\n    listBox1.Items.Add("There are " + counti.ToString().Trim() + " i's in the sentence");\n    listBox1.Items.Add("There are " + counto.ToString().Trim() + " o's in the sentence");\n    listBox1.Items.Add("There are " + countu.ToString().Trim() + " u's in the sentence");\n    listBox1.Items.Add("All in all there are " + (counta + counte + counti + counto + countu).ToString().Trim() + " vowels in the sentence");\n}
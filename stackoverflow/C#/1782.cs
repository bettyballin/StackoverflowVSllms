protected override void Render(HtmlTextWriter writer)\n{\n    // setup a TextWriter to capture the markup\n    TextWriter tw = new StringWriter();\n    HtmlTextWriter htw = new HtmlTextWriter(tw);\n\n    // render the markup into our surrogate TextWriter\n    base.Render(htw);\n\n    // get the captured markup as a string\n    string pageSource = tw.ToString();\n\n    string enabledUnchecked = "<input type=\"checkbox\" />";\n    string disabledChecked = "<input type=\"checkbox\" disabled checked />";\n\n    // TODO: need replacing ONLY inside a div with id="uwg"\n    string updatedPageSource = pageSource;\n    if (chk_CheckAll.Checked)\n    {\n         updatedPageSource = Regex.Replace(pageSource, enabledUnchecked,\n                disabledChecked, RegexOptions.IgnoreCase);\n    }\n\n    // render the markup into the output stream verbatim\n    writer.Write(updatedPageSource);\n}
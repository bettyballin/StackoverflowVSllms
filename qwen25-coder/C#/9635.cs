<#@ template debug="true" hostspecific="true"#>\n<#@ output extension=".txt" #>\n<#\n// Here you can use C# to programmatically control the generated text.\nstring message = "Hello, Model!";\n#>\nThis is a simple T4 template.\nGenerated text: <%= message %>
protected string GetWebDavUrl(string fileName)\n{\n    string webDavBaseUrl = "https://yourserver/webdav/";\n    return webDavBaseUrl + fileName;\n}\n\n// In your ASPX page\n<% foreach (var file in files) { %>\n    <a href="<%= GetWebDavUrl(file.FileName) %>">Edit <%= file.FileName %></a>\n<% } %>
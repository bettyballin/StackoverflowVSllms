<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="YourPage.aspx.cs" Inherits="YourNamespace.YourPage" %>\n\n<!DOCTYPE html>\n<html xmlns="http://www.w3.org/1999/xhtml">\n<head runat="server">\n    <title>Conditional HTML Rendering</title>\n</head>\n<body>\n    <form id="form1" runat="server">\n        <div>\n            <% if (YourCondition) { %>\n                <p>This HTML block will be included if YourCondition is true.</p>\n            <% } else { %>\n                <p>This HTML block will be included if YourCondition is false.</p>\n            <% } %>\n        </div>\n    </form>\n</body>\n</html>
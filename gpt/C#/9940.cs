<%@ Page Language="C#" AutoEventWireup="true" CodeFile="YourPage.aspx.cs" Inherits="YourNamespace.YourPage" %>\n<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="ajaxToolkit" %>\n\n<!DOCTYPE html>\n<html xmlns="http://www.w3.org/1999/xhtml">\n<head runat="server">\n    <title>Your Page Title</title>\n</head>\n<body>\n    <form id="form1" runat="server">\n        <asp:ScriptManager ID="ScriptManager1" runat="server" />\n        <asp:UpdatePanel ID="UpdatePanel1" runat="server">\n            <ContentTemplate>\n                <!-- Your partial update content goes here -->\n                <asp:Label ID="Label1" runat="server" Text="Hello, World!"></asp:Label>\n                <asp:Button ID="Button1" runat="server" Text="Update" OnClick="Button1_Click" />\n            </ContentTemplate>\n        </asp:UpdatePanel>\n    </form>\n</body>\n</html>
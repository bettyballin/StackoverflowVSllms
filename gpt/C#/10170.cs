<%@ Master Language="C#" AutoEventWireup="true" CodeBehind="MasterPage.master.cs" Inherits="YourNamespace.MasterPage" %>\n\n<!DOCTYPE html>\n<html>\n<head runat="server">\n    <title></title>\n</head>\n<body>\n    <form id="form1" runat="server">\n    <div>\n        <asp:ContentPlaceHolder ID="MainContent" runat="server">\n        </asp:ContentPlaceHolder>\n    </div>\n    </form>\n</body>\n</html>
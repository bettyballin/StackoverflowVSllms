<%@ Master Language="C#" AutoEventWireup="true" CodeBehind="MasterPage.master.cs" Inherits="YourNamespace.MasterPage" %>\n<!DOCTYPE html>\n<html>\n<head runat="server">\n    <title></title>\n    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>\n</head>\n<body>\n    <form id="form1" runat="server">\n        <asp:DropDownList ID="ddlSearchType" runat="server">\n            <asp:ListItem Text="Search by Name" Value="Name"></asp:ListItem>\n            <asp:ListItem Text="Search by ID" Value="ID"></asp:ListItem>\n        </asp:DropDownList>\n        \n        <asp:TextBox ID="txtSearch" runat="server"></asp:TextBox>\n        <asp:AutoCompleteExtender \n            ID="AutoCompleteExtender1" \n            runat="server" \n            TargetControlID="txtSearch" \n            ServiceMethod="GetCompletionList" \n            MinimumPrefixLength="1" \n            UseContextKey="true" \n            EnableCaching="true">\n        </asp:AutoCompleteExtender>\n    </form>\n</body>\n</html>
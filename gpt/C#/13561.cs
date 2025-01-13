<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="YourNamespace.Default" %>\n<!DOCTYPE html>\n<html>\n<head runat="server">\n    <title>Long Process Update</title>\n    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>\n    <script>\n        function updateStatus() {\n            $.ajax({\n                type: "POST",\n                url: "Default.aspx/GetStatus",\n                contentType: "application/json; charset=utf-8",\n                dataType: "json",\n                success: function (response) {\n                    $('#statusTextBox').val(response.d);\n                    if (response.d !== "Process Complete") {\n                        setTimeout(updateStatus, 1000);\n                    }\n                }\n            });\n        }\n    </script>\n</head>\n<body>\n    <form id="form1" runat="server">\n        <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>\n        <asp:UpdatePanel ID="UpdatePanel1" runat="server">\n            <ContentTemplate>\n                <asp:TextBox ID="statusTextBox" runat="server" ReadOnly="true"></asp:TextBox>\n                <asp:Button ID="startButton" runat="server" Text="Start Process" OnClick="startButton_Click" OnClientClick="updateStatus(); return false;" />\n            </ContentTemplate>\n        </asp:UpdatePanel>\n    </form>\n</body>\n</html>
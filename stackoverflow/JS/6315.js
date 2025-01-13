<script type="text/javascript">\n    function clientValidate(sender, args) {\n        if (args.Value.length > 200) {\n            args.IsValid = false;\n        }\n    }\n</script>\n\n<div>\n    <asp:TextBox runat="server" ID="TextBox1" TextMode="MultiLine"></asp:TextBox>\n    <asp:CustomValidator runat="server" ID="CustomValidator1" ControlToValidate="TextBox1"\n        Text="The text length exceeds the allowed maximum" \n        ClientValidationFunction="clientValidate" Display="Dynamic">\n    </asp:CustomValidator>\n    <asp:RequiredFieldValidator runat="server" ID="ReqFieldValidator1" ControlToValidate="TextBox1"\n        Text="You must enter a text!" Display="Dynamic">\n    </asp:RequiredFieldValidator>\n    <asp:Button runat="server" ID="Button1" Text="Postback" CausesValidation="true" />\n</div>
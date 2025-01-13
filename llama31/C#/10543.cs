<asp:GridView ID="YourGridView" runat="server" AutoGenerateColumns="false">\n    <Columns>\n        <asp:BoundField DataField="YourVarBinaryField" HeaderText="Your Field" />\n        <asp:TemplateField HeaderText="Your Field (Hex)">\n            <ItemTemplate>\n                <%# Eval("YourVarBinaryField", "{0:Hex}") %>\n            </ItemTemplate>\n        </asp:TemplateField>\n    </Columns>\n</asp:GridView>\n\n// In your code-behind\nprotected void Page_Load(object sender, EventArgs e)\n{\n    YourGridView.DataSource = YourDataTable;\n    YourGridView.DataBind();\n}
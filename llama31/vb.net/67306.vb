@if(Model.SelectedServerList != null) {\n    <%=Html.ListBox("SelectedServerList", Model.SelectedServerList, New With {.size = 8, .ondblclick = "removeServer();"})%>\n} else {\n    <%=Html.ListBox("SelectedServerList", New SelectList(New List(Of String)), New With {.size = 8, .ondblclick = "removeServer();"})%>\n}
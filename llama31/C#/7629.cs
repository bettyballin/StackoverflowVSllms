<% foreach (var mm in (ViewData["pendingmembers"] as List<MyMember>)) %>\n<% { %>\n   <tr><td>Username:<%=mm.UserName %></td><td>\n   <tr><td>Firstname:<%=mm.FirstName %></td><td>\n   ...etc...\n   <tr>\n      <td>\n      <% using (Html.BeginForm("AcceptPendingUser", "Admin")) { %>\n          <input type="hidden" name="id" value="<%= mm.Id %>" />\n          <input type="submit" value="Accept" />\n      <% } %>\n      </td>\n      <td>\n      <% using (Html.BeginForm("RejectPendingUser", "Admin")) { %>\n          <input type="hidden" name="id" value="<%= mm.Id %>" />\n          <input type="submit" value="Reject" />\n      <% } %>\n      </td>\n    </tr>\n<% } %>
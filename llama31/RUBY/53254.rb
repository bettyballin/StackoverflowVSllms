<table width="650" align="center" cellpadding="6" cellspacing="0">\n  <tr>\n    <td width="150"><a class="Contact<%=h @business.id %>" href="#"><%=h @business.name %></a></td>\n    <td width="150"><%=h @business.address %></td>\n    <td width="100"><%=h @business.business_category.name %></td>\n    <td width="200"><%=h @business.description %></td>\n    <td width="50"><%= link_to(image_tag('/images/accept.png', :alt => 'Approve'), :id =>@business.id, :action => 'approve') %>\n      <a class="Edit<%=h @business.id %>" href="#"><img src="/images/pencil.png" alt="Edit" /></a>\n    <%= link_to(image_tag('/images/bin.png', :alt => 'Remove'), @business, :confirm => 'Are you sure?', :method => :delete) %></td>\n  </tr>\n</table>
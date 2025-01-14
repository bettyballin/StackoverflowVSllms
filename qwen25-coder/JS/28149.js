// app/views/items/update_status.js.erb\n   <% if @item.errors.any? %>\n     alert('Failed to update status');\n   <% else %>\n     $('#item-<%= @item.id %> input[type="checkbox"]').prop('checked', <%= @item.approved %>);\n     $('#last_approved_by_user-<%= @item.id %>').text('<%= @item.approved_by_name %>');\n     $('#approved_at_timestamp-<%= @item.id %>').text('<%= @item.approved_at.strftime('%Y-%m-%d %H:%M:%S') %>');\n   <% end %>
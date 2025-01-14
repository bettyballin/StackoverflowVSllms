<% for room in @scrape %>\n<tr id="page_<%= room.id %>">\n  <th scope="row" class="<%= cycle("spec", "specalt") %>"><%= h room.name %></th>\n  <% day_columns = Room.column_names.select { |c| c.starts_with?('day') }.sort_by(&:to_i) %>\n  <% day_columns.each do |column| %>\n    <td class="<%= current_cycle %>"><%= h room.send(column) %></td>\n  <% end %>\n  <td class="<%= current_cycle %>">\n    <%= select_tag("room[#{room.id}]", options_for_select(0..room.spots, 0)) %>\n  </td>\n</tr>\n<% end %>
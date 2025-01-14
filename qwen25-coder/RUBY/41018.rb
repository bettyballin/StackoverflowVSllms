<%\n  miniature_counts = get_user_miniature_counts(current_user, @miniatures)\n%>\n\n<% @miniatures.each do |miniature| %>\n  <td><%= link_to miniature.name, miniature %></td>\n  <td><%= text_field_tag "counts[#{miniature.id}]", miniature_counts.fetch(miniature.id, 0), size: 2 %></td>\n<% end %>
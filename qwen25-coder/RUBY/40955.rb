<h1>Upcoming Birthdays</h1>\n<ul>\n  <% @upcoming_birthday_users.each do |user| %>\n    <li><%= user.name %> - <%= user.birthday_in_current_or_next_year.strftime('%B %d, %Y') %></li>\n  <% end %>\n</ul>
# _questions.html.erb\n<option value="">Select a question</option>\n<% questions.each do |question| %>\n  <option value="<%= question.id %>"><%= question.text %></option>\n<% end %>
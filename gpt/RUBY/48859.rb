<%= form_with(model: @project) do |f| %>\n  <%= f.label :title %>\n  <%= f.text_field :title %>\n\n  <%= f.fields_for :tasks do |task_form| %>\n    <%= task_form.label :title %>\n    <%= task_form.text_field :title %>\n  <% end %>\n\n  <%= f.submit %>\n<% end %>
<%= form_with(model: @your_model, local: true) do |form| %>\n  <%= form.text_field :value1 %>\n  <%= form.text_field :value2 %>\n  <% if @your_model.errors.any? %>\n    <%= form.hidden_field :resubmit, value: true %>\n    <%= form.submit 'Resubmit' %>\n  <% else %>\n    <%= form.submit 'Submit' %>\n  <% end %>\n<% end %>
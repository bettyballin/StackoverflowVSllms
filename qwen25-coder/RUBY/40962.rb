<%= form_for @contact_form, url: contact_path do |f| %>\n  <% if @contact_form.errors.any? %>\n    <div id="error_explanation">\n      <h2><%= pluralize(@contact_form.errors.count, "error") %> prohibited this form from being saved:</h2>\n\n      <ul>\n        <% @contact_form.errors.full_messages.each do |message| %>\n          <li><%= message %></li>\n        <% end %>\n      </ul>\n    </div>\n  <% end %>\n\n  <div class="field">\n    <%= f.label :name %>\n    <%= f.text_field :name %>\n  </div>\n\n  <div class="field">\n    <%= f.label :email %>\n    <%= f.email_field :email %>\n  </div>\n\n  <div class="field">\n    <%= f.label :message %>\n    <%= f.text_area :message %>\n  </div>\n\n  <div class="actions">\n    <%= f.submit "Send" %>\n  </div>\n<% end %>
# Add to your Gemfile\ngem 'wicked_pdf'\n\n# Run the following command in your terminal\nbundle install\n\n# In your controller\nclass MyController < ApplicationController\n  def index\n    respond_to do |format|\n      format.html\n      format.pdf do\n        render pdf: "addresses",\n               template: "my_controller/index.pdf.erb",\n               layout: "pdf.html.erb"\n      end\n    end\n  end\nend\n\n# In your view (my_controller/index.pdf.erb)\n<h1>Addresses</h1>\n<table>\n  <% @addresses.each do |address| %>\n    <tr>\n      <td><%= address.name %></td>\n      <td><%= address.street %></td>\n      <td><%= address.city %></td>\n      <td><%= address.state %></td>\n      <td><%= address.zip %></td>\n    </tr>\n  <% end %>\n</table>
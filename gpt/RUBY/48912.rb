<div id="flash-messages">\n  <% flash.each do |type, message| %>\n    <div class="flash <%= type %>"><%= message %></div>\n  <% end %>\n</div>
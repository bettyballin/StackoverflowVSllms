def build_html_list(file_list, path = '')\n  html = '<ul>'\n  file_list.each do |key, value|\n    if value.empty?\n      html += "<li><input type='checkbox' value='#{path}#{key}'> #{key}</li>"\n    else\n      html += "<li>#{key}</li><ul>"\n      html += build_html_list(value, "#{path}#{key}/")\n      html += '</ul>'\n    end\n  end\n  html += '</ul>'\nend
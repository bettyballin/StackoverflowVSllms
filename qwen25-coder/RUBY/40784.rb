def hide_div\n  respond_to do |format|\n    format.js # This will look for a file named hide_div.js.erb\n  end\nend
def validate_form\n  required_attributes = [:name, :age, :graph_type, :graph_width, :theme]\n  required_attributes.each do |attribute|\n    unless params[attribute].present?\n      flash[:error] = "Cannot leave '#{attribute}' blank"\n      redirect_to(url)\n      return false\n    end\n  end\nend
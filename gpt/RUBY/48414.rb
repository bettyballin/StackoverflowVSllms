# In graduate_students_controller\n   session[:graduate_students] ||= {}\n   session[:graduate_students][:some_key] = some_data\n\n   # In current_students_controller\n   session[:current_students] ||= {}\n   session[:current_students][:another_key] = some_other_data
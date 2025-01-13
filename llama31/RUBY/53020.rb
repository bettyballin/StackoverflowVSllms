# In your view\n<td><%= text_field_tag 'grade', grade.value, remote: true %></td>\n\n# In your controller\ndef update_grade\n  grade = Grade.find(params[:id])\n  grade.value = params[:grade]\n  grade.save\n  respond_to do |format|\n    format.json { render json: { success: true } }\n  end\nend
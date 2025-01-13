# students_controller.rb\ndef add_class\n  @student = Student.find(params[:id])\n  @student.classes << Class.find(params[:class_id])\n  @student.save\n  respond_to do |format|\n    format.json { head :no_content }\n  end\nend\n\ndef remove_class\n  @student = Student.find(params[:id])\n  @student.classes.destroy(Class.find(params[:class_id]))\n  @student.save\n  respond_to do |format|\n    format.json { head :no_content }\n  end\nend
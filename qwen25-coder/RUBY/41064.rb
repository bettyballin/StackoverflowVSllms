def create\n  @task = Task.new(task_params)\n  @note = Note.new(note_params)\n  \n  # Manually associate and validate\n  @task.notes << @note\n  \n  if @task.valid? && @note.valid?\n    @task.save!\n    redirect_to tasks_path\n  else\n    render :action => 'new'\n  end\nend\n\nprivate\n\ndef task_params\n  params.require(:task).permit(:attribute1, :attribute2) # Add actual attributes here\nend\n\ndef note_params\n  params.require(:note).permit(:body) # Ensure you permit only the allowed parameters\nend
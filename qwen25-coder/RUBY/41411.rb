def create\n  @widget = Widget.create(widget_params)\n  if @widget.save\n    @widget_objects = Widget.all.index_by(&:id).transform_values(&:attributes)\n    render json: { success: 'Widget saved successfully.', widget_objects: @widget_objects }\n  else\n    render json: { errors: @widget.errors.full_messages }, status: :unprocessable_entity\n  end\nend
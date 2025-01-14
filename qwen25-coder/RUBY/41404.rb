def create\n  @resource = Resource.new(resource_params)\n\n  if @resource.save\n    respond_to do |format|\n      format.html { redirect_to @resource, notice: 'Resource was successfully created.' }\n      format.js   # This will look for a file called create.js.erb in the views/resources directory\n    end\n  else\n    respond_to do |format|\n      format.html { render :new }\n      format.js   # This will handle errors on AJAX requests\n    end\n  end\nend
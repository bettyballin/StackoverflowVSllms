def add_comment\n  @resource = Resource.find(params[:id])\n  \n  if my_validation?\n    # Process success logic here\n    save_the_object\n    redirect_to :action => "show", :id => params[:id], notice: 'Comment was successfully added.'\n  else\n    render :action => "show" # No need to pass the ID again as it is already found and stored in @resource\n  end\nend\n\nprivate\n\ndef my_validation?\n  # Implement your validation logic here\nend\n\ndef save_the_object\n  # Save the comment or any other relevant data processing\nend
# Returning JSON in a controller action\n  def show\n    @user = User.find(params[:id])\n    render json: { user: @user }\n  end
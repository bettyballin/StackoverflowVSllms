# Example routing\nGET /users  # UsersController.index handles both find by email or username\n\n# In the controller action:\ndef index\n  if params[:username] && params[:password]\n    @user = User.find_by(username: params[:username], password: params[:password])\n  elsif params[:email]\n    @user = User.find_by(email: params[:email])\n  else\n    @users = User.all\n  end\nend
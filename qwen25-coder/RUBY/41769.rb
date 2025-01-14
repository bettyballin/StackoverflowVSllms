# app/controllers/users_controller.rb (or wherever appropriate for user sign-up)\ndef create\n  @user = User.new(user_params)\n\n  if @user.save\n    DefaultChecklistService.load_default_checklist(@user)\n    # Redirect or render success page\n  else\n    # Handle error\n  end\nend\n\nprivate\n\ndef user_params\n  params.require(:user).permit(:name, :email, :password)\nend
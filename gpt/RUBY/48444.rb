# In your controller\ndef show\n  @user = User.find(params[:id])\n  @contacts = @user.contacts\nend
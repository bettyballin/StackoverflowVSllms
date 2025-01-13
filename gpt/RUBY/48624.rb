class EmailsController < ApplicationController\n  before_action :set_user\n  before_action :set_publicprofile\n\n  def create\n    @email = @publicprofile.emails.build(email_params)\n    if @email.save\n      redirect_to user_publicprofile_path(@user), notice: 'Email was successfully created.'\n    else\n      render :new\n    end\n  end\n\n  # Add other actions (index, show, edit, update, destroy) as needed\n\n  private\n\n  def set_user\n    @user = User.find(params[:user_id])\n  end\n\n  def set_publicprofile\n    @publicprofile = @user.publicprofile\n  end\n\n  def email_params\n    params.require(:email).permit(:address)\n  end\nend
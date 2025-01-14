class PublicprofilesController < ApplicationController\n  before_action :set_user\n\n  def show\n    @publicprofile = @user.publicprofile\n  end\n\n  def update\n    @publicprofile = @user.publicprofile\n    if @publicprofile.update(publicprofile_params)\n      redirect_to user_publicprofile_path(@user), notice: 'Profile was successfully updated.'\n    else\n      render :edit\n    end\n  end\n\n  private\n\n  def set_user\n    @user = User.find(params[:user_id])\n  end\n\n  def publicprofile_params\n    params.require(:publicprofile).permit(emails_attributes: [:id, :address, :_destroy], phonenumbers_attributes: [:id, :number, :_destroy])\n  end\nend
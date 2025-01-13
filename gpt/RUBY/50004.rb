class WorkoutsController < ApplicationController\n  before_action :authenticate_user!, except: :show\n  before_action :set_workout, only: :show\n\n  def show\n    if params[:user_login]\n      # Handle public access logic here\n      @user = User.find_by(login: params[:user_login])\n      @workout = @user.workouts.find(params[:id])\n    else\n      # Handle authenticated user access logic here\n      @workout = current_user.workouts.find(params[:id])\n    end\n  end\n\n  private\n\n  def set_workout\n    # Set the workout based on the user login and workout ID\n    @workout = Workout.find(params[:id])\n  end\nend
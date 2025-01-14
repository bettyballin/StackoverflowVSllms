class PostsController < ApplicationController\n  before_action :authenticate_user! # Ensure the user is authenticated\n\n  def new\n    @post = Post.new\n\n    respond_to do |format|\n      format.html # new.html.erb\n      format.xml  { render :xml => @post }\n    end\n  end\n\n  def create\n    @post = Post.new(post_params)\n    @post.user = current_user # Assign the current user to the post\n\n    respond_to do |format|\n      if @post.save\n        format.html { redirect_to @post, notice: 'Post was successfully created.' }\n        format.xml  { render :xml => @post, status: :created, location: @post }\n      else\n        format.html { render :new }\n        format.xml  { render :xml => @post.errors, status: :unprocessable_entity }\n      end\n    end\n  end\n\n  private\n\n  def post_params\n    params.require(:post).permit(:subject, :body) # Strong parameters\n  end\nend
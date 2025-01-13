class StoriesController < ApplicationController\n  def index\n    @stories = Story.all\n    respond_to do |format|\n      format.html  # index.html.erb\n      format.json  { render :json => @stories }\n    end\n  end\n\n  def show\n    @story = Story.find(params[:id])\n    respond_to do |format|\n      format.html  # show.html.erb\n      format.json  { render :json => @story }\n    end\n  end\n\n  def new\n    @story = Story.new\n    respond_to do |format|\n      format.html  # new.html.erb\n      format.json  { render :json => @story }\n    end\n  end\n\n  def create\n    @story = Story.new(params[:story])\n    respond_to do |format|\n      if @story.save\n        format.html  { redirect_to(@story, :notice => 'Story was successfully created.') }\n        format.json  { render :json => @story, :status => :created, :location => @story }\n      else\n        format.html  { render :action => "new" }\n        format.json  { render :json => @story.errors, :status => :unprocessable_entity }\n      end\n    end\n  end\n\n  def update\n    @story = Story.find(params[:id])\n    respond_to do |format|\n      if @story.update_attributes(params[:story])\n        format.html  { redirect_to(@story, :notice => 'Story was successfully updated.') }\n        format.json  { render :json => @story }\n      else\n        format.html  { render :action => "edit" }\n        format.json  { render :json => @story.errors, :status => :unprocessable_entity }\n      end\n    end\n  end\n\n  def destroy\n    @story = Story.find(params[:id])\n    @story.destroy\n    respond_to do |format|\n      format.html  { redirect_to(stories_url) }\n      format.json  { render :json => true }\n    end\n  end\nend
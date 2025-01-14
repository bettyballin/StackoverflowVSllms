# app/controllers/comments_controller.rb\n   class CommentsController < ApplicationController\n     include Pundit\n\n     def update\n       @comment = Comment.find(params[:id])\n       authorize @comment\n       if @comment.update(comment_params)\n         redirect_to @comment, notice: 'Comment was successfully updated.'\n       else\n         render :edit\n       end\n     rescue Pundit::NotAuthorizedError\n       redirect_to root_path, alert: "You are not authorized to perform this action."\n     end\n\n     private\n\n     def comment_params\n       params.require(:comment).permit(:body, :status)\n     end\n   end
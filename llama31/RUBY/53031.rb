def create\n  begin\n    @post = Post.find(params[:post_id])\n    @comment = @post.comments.new(params[:comment])\n    @comment.name = 'Anonymous' if @comment.name.nil?\n    if @comment.save\n      # ...
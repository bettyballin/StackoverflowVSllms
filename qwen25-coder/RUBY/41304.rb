def create\n  @post = current_user.posts.build(post_params)\n\n  respond_to do |format|\n    if @post.save\n      format.html { redirect_to @post, notice: 'Post was successfully created.' }\n      format.json { render :show, status: :created, location: @post }\n    else\n      format.html { render :new }\n      format.json { render json: @post.errors, status: :unprocessable_entity }\n    end\n  end\nend\n\nprivate\n\ndef post_params\n  params.require(:post).permit(:subject, :body)\nend
def search\n  @results = Model.where("name LIKE ?", "%#{params[:query]}%")\n  respond_to do |format|\n    format.js # This will render search.js.erb\n    format.html\n  end\nend
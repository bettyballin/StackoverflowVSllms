# Example using ActiveRecord\n   @articles = Article.joins(:author).where("published = ? OR authors.id = ?", true, current_user.id)
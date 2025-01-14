# Bad: N+1 queries\nposts = Post.all\nposts.each do |post|\n  puts post.comments.count\nend\n\n# Good: Eager loading\nposts = Post.includes(:comments)\nposts.each do |post|\n  puts post.comments.count\nend
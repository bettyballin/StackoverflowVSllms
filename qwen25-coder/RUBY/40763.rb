require 'octokit'\n\nclient = Octokit::Client.new(access_token: 'your_github_access_token')\n\n# Search for repositories using Passenger\nsearch_query = 'Passenger in:readme'\nresults = client.search_repositories(search_query)\n\nresults.items.each do |repo|\n  puts "Repository: #{repo.full_name}"\nend
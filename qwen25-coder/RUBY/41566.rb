class AggregatedData < ActiveResource::Base\n  self.site = "http://example.com/"\n\n  def self.find_aggregated_data(username, article_id)\n    response = get("aggregated_data/show.json", username: username, id: article_id).body\n    data = JSON.parse(response)\n\n    user = User.new(data['user'])\n    article = Article.new(data['article'])\n\n    [user, article]\n  end\nend\n\n# Usage:\nuser, article = AggregatedData.find_aggregated_data('joe', 1)
<% if activity.read_attribute(:context) == 'ItemComment' %>\n  <%= render :partial => 'item_comments/comment', :object => ItemComment.find(activity.context_id) %>\n<% elsif activity.read_attribute(:context) == 'Review' %>\n  <%= render :partial => 'reviews/review', :object => Review.find(activity.context_id) %>
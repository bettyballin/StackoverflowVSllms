class CollectionsController < ApplicationController\n  def index\n    @miniatures = Miniature.left_joins(:ownerships)\n                           .select('miniatures.*, COALESCE(ownerships.have_count, 0) AS have_count')\n                           .where('ownerships.user_id = ? OR ownerships.user_id IS NULL', current_user.id)\n  end\nend
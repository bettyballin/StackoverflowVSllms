# Define abilities in Ability class\nclass Ability\n  include CanCan::Ability\n\n  def initialize(user)\n    user ||= User.new # guest user (not logged in)\n\n    if user.admin?\n      can :manage, :all\n    else\n      can :read, Article\n      can [:create, :update], Article, author_id: user.id\n    end\n  end\nend
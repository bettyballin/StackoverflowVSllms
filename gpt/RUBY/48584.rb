class MyController < ApplicationController\n  def first_action\n    # Your logic for the first action\n    redirect_to action: :second_action\n  end\n\n  def second_action\n    # Your logic for the second action\n  end\nend
class Payment < ApplicationController\n  before_filter :login_required\n\n  def new\n    unless performed?\n      redirect_to some_other_path if @order.is_free?\n    end\n    @payment = Payment.new\n  end\nend
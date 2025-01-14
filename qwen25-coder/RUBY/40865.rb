class OrdersController < ApplicationController\n  before_action :set_order\n\n  def update\n    if current_user.admin?\n      # Allow all attributes for admin users\n      updated_attributes = order_params_admin\n    else\n      # Limit the allowed attributes for regular users\n      updated_attributes = order_params_user\n    end\n\n    if @order.update(updated_attributes)\n      redirect_to @order, notice: 'Order was successfully updated.'\n    else\n      render :edit\n    end\n  end\n\n  private\n\n  def set_order\n    @order = Order.find(params[:id])\n  end\n\n  def order_params_admin\n    params.require(:order).permit!\n  end\n\n  def order_params_user\n    params.require(:order).permit(:billing_address)\n  end\nend
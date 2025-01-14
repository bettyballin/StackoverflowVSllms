class OrdersController < ApplicationController\n  include Wicked::Wizard\n\n  steps *Order.state_machine.states.map(&:name)\n\n  def show\n    @order = find_order\n    render_wizard\n  end\n\n  def update\n    @order = find_order\n    @order.attributes = order_params\n\n    if @order.valid?\n      render_wizard @order\n    else\n      render_wizard\n    end\n  end\n\n  private \n\n  def order_params\n    params.require(:order).permit(permitted_params)\n  end\n\n  def permitted_params\n    case step\n    when :step1\n      [:field_a, :field_b]\n    when :step2\n      [:field_c, :image]\n    else\n     [:other_params]\n    end\n  end\n\n  def find_order\n    @order ||= Order.find(params[:id])\n  end\nend
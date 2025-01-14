class MultiStepFormController < ApplicationController\n  before_action :load_form_data\n\n  def first_step\n    render 'first_step'\n  end\n\n  def second_step\n    if @form_data.update(params[:multi_step_form])\n      session[:form_data] = @form_data.to_h\n      render 'second_step'\n    else\n      render 'first_step'\n    end\n  end\n\n  def third_step\n    # Merge new params with existing form data stored in session\n    form_data_params = @form_data.to_h.merge(params[:multi_step_form])\n\n    @form_data = MultiStepForm.new(form_data_params)\n\n    if @form_data.valid?\n      @form_data.save!\n      reset_session_form_data\n      redirect_to success_path, notice: "Form submitted successfully."\n    else\n      session[:form_data] = form_data_params\n      render 'second_step'\n    end\n  end\n\n  private\n\n  def load_form_data\n    @form_data ||= MultiStepForm.new(session[:form_data])\n    @form_data.assign_attributes(params.require(:multi_step_form)) if params.key?(:multi_step_form)\n  end\n\n  def reset_session_form_data\n    session.delete(:form_data)\n  end\nend
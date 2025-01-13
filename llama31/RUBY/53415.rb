class ContactsController < ApplicationController\n  def create\n    @contact = Contact.new(contact_params)\n\n    if @contact.valid?\n      # Send email using ActionMailer\n      ContactMailer.send_email(@contact.subject, @contact.message).deliver_now\n      redirect_to root_path, notice: "Email sent successfully"\n    else\n      render :new\n    end\n  end\n\n  private\n\n  def contact_params\n    params.require(:contact).permit(:subject, :message)\n  end\nend
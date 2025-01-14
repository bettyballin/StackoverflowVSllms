class Product < ApplicationRecord\n  validates_presence_of :name, on: [:create, :update]\n  validates_format_of :name, with: /^([a-zA-Z0-9\ \-]{3,128})$/i, on: [:create, :update]\n\n  has_attached_file :image\n\n  # Add context checks for image validations\n  validates_attachment_presence :image, if: :should_validate_image?\n  validates_attachment_content_type :image, content_type: ["image/jpeg", "image/png", "image/gif"], if: :should_validate_image?\n\n  private\n\n  def should_validate_image?\n    # Example condition: only validate the image during specific actions or based on a parameter\n    action_name == 'upload_image' || params[:uploading_image]\n  end\nend
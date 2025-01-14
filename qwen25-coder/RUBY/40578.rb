def create\n  ActiveRecord::Base.transaction do\n    @item = Item.new(item_params)\n    @item.save! # raises an exception if it fails validations\n\n    another_item = AnotherItem.create!(some_params) # also will roll back if this fails\n  end\nrescue ActiveRecord::RecordInvalid => e\n  render json: { errors: e.record.errors }, status: :unprocessable_entity\nend
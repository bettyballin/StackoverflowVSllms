# In your controller action handling the AJAX request\nrender partial: "staff_members/forms/personal_details", locals: { f: @form_builder_instance, skill_groups: @skill_groups, staff_member: @staff_member }
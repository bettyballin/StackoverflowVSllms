DECLARE @numbers VARCHAR(255)\n\nSELECT @numbers = COALESCE(@numbers + ' | ','') + PHONE_NUMB FROM my_table (NOLOCK)\nWHERE CONTACT_ID=@contact_id   RETURN @numbers
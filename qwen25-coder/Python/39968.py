def clean_nzb(self):\n    file = self.cleaned_data.get('nzb')\n    if not file.name.endswith('.xml'):\n        raise forms.ValidationError("File must be an XML.")\n    \n    try:\n        instance = YourModel(nzb=file)\n        # Example usage of a method\n        some_value = instance.parse_nzb(file)\n        instance.some_field_from_xml = some_value  # Assign value to model field\n        \n        # Save or update the instance as needed\n        if self.instance.pk:\n            instance.update()\n        else:\n            instance.save()\n    except Exception as e:\n        raise forms.ValidationError(f"Error processing file: {str(e)}")\n    \n    return instance.nzb
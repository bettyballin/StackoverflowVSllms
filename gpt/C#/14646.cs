public partial class DetailsControl : UserControl\n{\n    public DetailsControl()\n    {\n        InitializeComponent();\n        this.Validating += DetailsControl_Validating;\n    }\n\n    private void DetailsControl_Validating(object sender, CancelEventArgs e)\n    {\n        // Perform validation\n        bool isValid = ValidateObject();\n        if (!isValid)\n        {\n            e.Cancel = true;\n            return;\n        }\n\n        // Attempt to save the object\n        try\n        {\n            SaveObject();\n        }\n        catch (Exception ex)\n        {\n            // Handle save error\n            MessageBox.Show("An error occurred while saving: " + ex.Message);\n            e.Cancel = true;\n        }\n    }\n\n    private bool ValidateObject()\n    {\n        // Add validation logic here\n        // Return true if valid, false otherwise\n        return true;\n    }\n\n    private void SaveObject()\n    {\n        // Add save logic here\n        // Throw an exception if save fails\n    }\n}
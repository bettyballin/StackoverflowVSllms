MessageBox.Show(String.Format("{0} saved successfully.", Me.BusinessUnitTypeName), \n                "Save Successful", \n                MessageBoxButtons.OK, \n                MessageBoxIcon.Information, \n                MessageBoxDefaultButton.Button1)\n\n' Bring the main MDI parent form to the front\nMe.MdiParent.BringToFront()
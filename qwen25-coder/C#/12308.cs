using System;\nusing System.Web.UI;\n\nnamespace RBLPostBackIssue\n{\n    public partial class _Default : System.Web.UI.Page\n    {\n        protected void Page_PreLoad(object sender, EventArgs e)\n        {\n            if (!IsPostBack)\n            {\n                switch (new Random().Next(2))\n                {\n                    case 0:\n                        Label1.Text = "Initial value set to Yes";\n                        RadioButtonList1.SelectedValue = "Yes";\n                        break;\n                    case 1:\n                        Label1.Text = "Initial value set to No";\n                        RadioButtonList1.SelectedValue = "No";\n                        break;\n                }\n            }\n        }\n\n        protected void Page_Load(object sender, EventArgs e)\n        {\n            if (!IsPostBack)\n            {\n                ShowHideLogic();\n            }\n        }\n\n        private void ShowHideLogic()\n        {\n            PlaceHolder1.Visible = RadioButtonList1.SelectedValue.ToLower().Equals("yes");\n        }\n\n        protected override void LoadViewState(object savedState)\n        {\n            base.LoadViewState(savedState);\n            if (IsPostBack)\n            {\n                // Ensure the selected value from ViewState is set after LoadViewState\n                ShowHideLogic();\n            }\n        }\n\n        protected void RadioButtonList1_SelectedIndexChanged(object sender, EventArgs e)\n        {\n            ShowHideLogic();\n        }\n    }\n}
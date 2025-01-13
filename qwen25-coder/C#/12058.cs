using System;\n\nnamespace YourNamespace\n{\n    public partial class VotingPage : System.Web.UI.Page\n    {\n        private int VoteCount\n        {\n            get { return ViewState["VoteCount"] != null ? (int)ViewState["VoteCount"] : 0; }\n            set { ViewState["VoteCount"] = value; }\n        }\n\n        protected void Page_Load(object sender, EventArgs e)\n        {\n            if (!IsPostBack)\n            {\n                VoteCount = 0;\n            }\n\n            // Handle postback from JavaScript click events\n            string eventTarget = Request["__EVENTTARGET"];\n            if (eventTarget == UniqueID + "$UpdatePanel1")\n            {\n                string eventArgument = Request["__EVENTARGUMENT"];\n                switch (eventArgument)\n                {\n                    case "up":\n                        VoteCount++;\n                        break;\n                    case "down":\n                        VoteCount--;\n                        break;\n                }\n                lblVoteCount.Text = VoteCount.ToString();\n            }\n        }\n    }\n}
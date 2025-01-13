public partial class ConfirmModal : System.Web.UI.UserControl\n{\n    protected string InstanceId = Guid.NewGuid().ToString("N");\n\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        if (!IsPostBack)\n        {\n            Modal.PopupControlID = ConfirmDiv.ClientID;\n            Modal.TargetControlID = HiddenButton.UniqueID;\n            Modal.OkControlID = BtnOk.ID;\n            Modal.CancelControlID = BtnNo.ID;\n        }\n    }\n\n    public string InstanceIdJS => $"confirmCtrl{InstanceId}";\n}
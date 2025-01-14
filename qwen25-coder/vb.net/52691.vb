Public Class dlgShowAssets\n    Private defaultWindowSize As Size\n    Private defaultAssetDGVSize As Size\n    Private defaultAssetDGVPos As Point\n\n    Private defaultButton1Pos As Point\n    Private defaultButton2Pos As Point\n    Private defaultButton3Pos As Point\n\n    Private defaultDetailDGVSize As Size\n    Private defaultDetailDGVPos As Point\n\n    Private Sub dlgShowAssets_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load\n        ' Store the initial sizes and positions when the form loads\n        defaultWindowSize = Me.Size\n        defaultAssetDGVSize = AssetDataGridView.Size\n        defaultAssetDGVPos = AssetDataGridView.Location\n\n        defaultButton1Pos = btnAddAsset.Location\n        defaultButton2Pos = btnEditAsset.Location\n        defaultButton3Pos = btnDeleteAsset.Location\n\n        defaultDetailDGVSize = AssetIdentifierDataGridView.Size\n        defaultDetailDGVPos = AssetIdentifierDataGridView.Location\n    End Sub\n\n    Private Sub dlgShowAssets_ResizeEnd(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.ResizeEnd\n        Dim deltaX As Integer = Me.Size.Width - defaultWindowSize.Width\n        Dim deltaY As Integer = Me.Size.Height - defaultWindowSize.Height\n        Dim deltaSize As New Size(deltaX, deltaY / 2)\n        Dim deltaPos As New Point(0, deltaY / 2)\n\n        AssetDataGridView.Size = defaultAssetDGVSize + deltaSize\n\n        btnAddAsset.Location = defaultButton1Pos + deltaPos\n        btnEditAsset.Location = defaultButton2Pos + deltaPos\n        btnDeleteAsset.Location = defaultButton3Pos + deltaPos\n\n        AssetIdentifierDataGridView.Size = defaultDetailDGVSize + deltaSize\n        AssetIdentifierDataGridView.Location = defaultDetailDGVPos + deltaPos\n    End Sub\nEnd Class
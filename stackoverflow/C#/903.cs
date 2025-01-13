public class Constants\n{\n    public const int MAX_PATH = 260;\n    public const int MAX_ZONE_PATH = 260;\n    public const int MAX_ZONE_DESCRIPTION = 200;\n}\n\n[StructLayout(LayoutKind.Sequential, CharSet=CharSet.Unicode)]\npublic struct ZONEATTRIBUTES\n{\n    public uint cbSize;\n    [MarshalAs(UnmanagedType.ByValTStr, SizeConst = Constants.MAX_PATH)]\n    public string szDizplayName;\n    [MarshalAs(UnmanagedType.ByValTStr, SizeConst = Constants.MAX_ZONE_DESCRIPTION)]\n    public string szDescription;\n    [MarshalAs(UnmanagedType.ByValTStr, SizeConst = Constants.MAX_PATH)]\n    public string szIconPath;\n    public uint dwTemplateMinLevel;\n    public uint dwTemplateRecommended;\n    public uint dwTemplateCurrentLevel;\n    public uint dwFlags;\n}\n\npublic enum URLZONEREG\n{\n    URLZONEREG_DEFAULT = 0,\n    URLZONEREG_HKLM,\n    URLZONEREG_HKCU\n}\n\n[Guid("79eac9ef-baf9-11ce-8c82-00aa004ba90b")]\n[ComImport]\npublic interface IInternetZoneManager\n{\n    void CopyTemplatePoliciesToZone(uint dwTemplate, uint dwZone, uint dwReserved);\n    void CreateZoneEnumerator(ref uint pdwEnum, ref uint pdwCount, uint dwFlags);\n    void DestroyZoneEnumerator(uint dwEnum);\n    void GetZoneActionPolicy(uint dwZone, uint dwAction, IntPtr pPolicy, uint cbPolicy, \n        URLZONEREG urlZoneReg);\n    void GetZoneAt(uint dwEnum, uint dwIndex, ref uint pdwZone);\n    void GetZoneAttributes(uint dwZone, ref ZONEATTRIBUTES pZoneAttributes);\n    void GetZoneCustomPolicy(uint dwZone, [In] ref Guid guidKey, ref IntPtr ppPolicy,\n        ref uint pcbPolicy, URLZONEREG urlZoneReg);\n    void LogAction(uint dwAction, [MarshalAs(UnmanagedType.LPWStr)] string pwszUrl, \n        [MarshalAs(UnmanagedType.LPWStr)] string pwszText, uint dwLogFlags);\n    void PromptAction(uint dwAction, IntPtr hwndParent, [MarshalAs(UnmanagedType.LPWStr)] string pwszUrl,\n        [MarshalAs(UnmanagedType.LPWStr)] string pwszText, uint dwPromptFlags);\n    void SetZoneActionPolicy(uint dwZone, uint dwAction, IntPtr pPolicy, uint cbPolicy,\n        URLZONEREG urlZoneReg);\n    void SetZoneAttributes(uint dwZone, ref ZONEATTRIBUTES pZoneAttributes);\n    void SetZoneCustomPolicy(uint dwZone, [In] ref Guid guidKey, IntPtr pPolicy,\n        uint pcbPolicy, URLZONEREG urlZoneReg);\n}
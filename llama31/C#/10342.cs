// a.aspx\n<div>\n    <% Html.Partial("b"); %>\n</div>\n\n// b.ascx (note: it's a user control, not an aspx page)\n<%@ Control Language="C#" AutoEventWireup="true" CodeFile="b.ascx.cs" Inherits="b" %>\nContent String
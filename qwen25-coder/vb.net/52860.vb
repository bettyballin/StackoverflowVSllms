<%@ Control Language="vb" AutoEventWireup="false" Codebehind="ProductRender.ascx.vb" Inherits="MyApp.ProductRender" TargetSchema="http://schemas.microsoft.com/intellisense/ie5" %>\n   <div>\n     <h3><%# Eval("Title") %></h3>\n     <img src='<%# Eval("Thumbnail") %>' />\n     <p><%# Eval("Description") %></p>\n   </div>
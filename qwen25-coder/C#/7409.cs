<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="NonStockSystem.Views.Admin.Index" %>\n   <%@ Import Namespace="NonStockSystem.Models" %>\n   <%@ Import Namespace="NonStockSystem.ViewModels" %>\n   <asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">\n\n       <ul>\n           <% foreach (Category c in ((AdminViewModel)Model).Categories)\n              { %>\n               <li><a href="#<%=c.Name.ToString() %>"><%=c.Name.ToString() %></a></li>\n           <% } %>\n       </ul>\n\n       <hr />\n\n       <% foreach (Category c in ((AdminViewModel)Model).Categories)\n          { %>\n           <h2><a name="<%=c.Name.ToString() %>"><%=c.Name.ToString() %></a></h2>\n\n           <% foreach (Product p in ((AdminViewModel)Model).Products.Where(product => product.CategoryID == c.ID))\n              { %>\n               <%=p.Name.ToString() %> (<a href="/Admin/Edit/<%=p.ID.ToString() %>">Edit</a> - <a href="/Admin/Delete/<%=p.ID.ToString() %>">Delete</a>)<br />\n           <% } %>\n       <% } %>\n\n   </asp:Content>
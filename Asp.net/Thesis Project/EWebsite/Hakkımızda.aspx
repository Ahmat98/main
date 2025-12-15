<%@ Page Title="" Language="C#" MasterPageFile="~/indexSite.Master" AutoEventWireup="true" CodeBehind="Hakkımızda.aspx.cs" Inherits="EWebsite.Hakkımızda" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">


        .auto-style22 {
            color: #000000;
        }

        </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder3" runat="server">
    <asp:Label ID="lblKullanici" runat="server" CssClass="auto-style22"></asp:Label>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder2" runat="server">
    <table align="left" class="auto-style21">
        <tr>
            <td class="auto-style14" style="text-align: left">
                <h1>myWebsite&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </h1>
            </td>
            <td>
                <asp:TextBox Style="padding-bottom: 0px; margin-right: 0" ID="txtBul" runat="server" Width="302px" Height="30px"></asp:TextBox>
            </td>
            <td>
                <asp:ImageButton ID="ibtnbul" runat="server" Height="28px" ImageUrl="~/resim/search.jpg" Width="45px" />
            </td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <asp:ImageButton ID="ImageButton8" runat="server" Height="28px" ImageUrl="~/resim/5771782.png" Width="45px" />
                &nbsp;&nbsp;
                            <asp:ImageButton ID="ImageButton7" runat="server" Height="28px" ImageUrl="~/resim/3689123.png" Width="45px" />
                &nbsp;&nbsp;
                            <asp:ImageButton ID="ImageButton6" runat="server" Height="28px" ImageUrl="~/resim/229098.png" Width="45px" />
                &nbsp;&nbsp;<asp:ImageButton ID="btn_Spt" runat="server" Height="28px" ImageUrl="~/resim/950812.png" Width="45px" />
            </td>
        </tr>
    </table>
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:Image ID="Image4" runat="server" Height="513px" ImageUrl="~/elektronik/aboutus.png" Width="1153px" />
</asp:Content>

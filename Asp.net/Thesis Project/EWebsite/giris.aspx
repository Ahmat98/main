<%@ Page Title="" Language="C#" MasterPageFile="~/indexSite.Master" AutoEventWireup="true" CodeBehind="giris.aspx.cs" Inherits="EWebsite.giris" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
    .auto-style22 {
        width: 489px;
        height: 301px;
        color: #000000;
        background-color: #99FF99;
    }
    .auto-style23 {
        text-align: center;
        text-decoration: underline;
    }
    .auto-style24 {
        font-size: large;
    }
    .auto-style25 {
        text-align: center;
    }
    .auto-style26 {
        font-size: large;
        color: #FF3300;
    }

        .auto-style12 {
            width: 100%;
        }

        </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder3" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder2" runat="server">
    <table class="auto-style12">
    <tr style="width: 100px; text-align: center">
        <td class="auto-style13">
            <table align="left" class="auto-style21">
                <tr>
                    <td class="auto-style14" style="text-align: left">
                        <h1>myWebsite&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </h1>
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
                        &nbsp;&nbsp;<asp:ImageButton ID="btn_Spt" runat="server" Height="28px" ImageUrl="~/resim/950812.png" Width="45px"/>
                    </td>
                </tr>
            </table>
                &nbsp;&nbsp;&nbsp;
            </td>
    </tr>
</table>
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table align="center" class="auto-style22">
    <tr>
        <td colspan="2">
            <h1 class="auto-style23">Giriş Yap</h1>
        </td>
    </tr>
    <tr>
        <td class="auto-style24">Kullanıcı Adı:</td>
        <td>
            <asp:TextBox ID="txt_kullanici" runat="server" CssClass="auto-style24" Width="249px"></asp:TextBox>
        </td>
    </tr>
    <tr>
        <td class="auto-style24">Şifre:</td>
        <td>
            <asp:TextBox ID="txt_sifre" runat="server" CssClass="auto-style24" Width="249px" TextMode="Password"></asp:TextBox>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <h2 class="auto-style25">
                <asp:Button ID="btngiris" runat="server" CssClass="auto-style13" OnClick="btngiris_Click" Text="Giriş" Width="309px" />
&nbsp;</h2>
        </td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>
            <asp:Label ID="lbl_msg" runat="server" CssClass="auto-style26"></asp:Label>
        </td>
    </tr>
</table>
</asp:Content>

<%@ Page Title="" Language="C#" MasterPageFile="~/indexSite.Master" AutoEventWireup="true" CodeBehind="iletisim.aspx.cs" Inherits="EWebsite.iletisim" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
        .auto-style22 {
            width: 568px;
            height: 454px;
            color: #000000;
            background-color: #66FF99;
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
        .auto-style27 {
            font-size: large;
            text-align: center;
        }
    
        .auto-style12 {
            width: 100%;
        }

        </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder3" runat="server">
    <asp:Label ID="lblKullanici" runat="server" CssClass="auto-style22"></asp:Label>
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
                        &nbsp;&nbsp;<asp:ImageButton ID="btn_Spt" runat="server" Height="28px" ImageUrl="~/resim/950812.png" Width="45px" />
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
                <h1 class="auto-style23">Bizimle iletişim geç</h1>
            </td>
        </tr>
        <tr>
            <td class="auto-style27">Ad:</td>
            <td class="auto-style25">
                <asp:TextBox ID="TextBox1" runat="server" CssClass="auto-style24" Width="325px"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td class="auto-style27">Soyad:</td>
            <td class="auto-style25">
                <asp:TextBox ID="TextBox2" runat="server" CssClass="auto-style24" Width="325px"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td class="auto-style27">Ülke:</td>
            <td class="auto-style25">
                    <asp:DropDownList ID="DropDownList1" runat="server" Height="35px" Width="336px" CssClass="auto-style24">
                        <asp:ListItem>Ülke Seçınız</asp:ListItem>
                        <asp:ListItem>Türkiye</asp:ListItem>
                        <asp:ListItem>Çad</asp:ListItem>
                        <asp:ListItem>Usa</asp:ListItem>
                    </asp:DropDownList>
                    </td>
        </tr>
        <tr>
            <td class="auto-style27">Konu:</td>
            <td class="auto-style25">
                <asp:TextBox ID="TextBox3" runat="server" CssClass="auto-style24" Height="67px" TextMode="MultiLine" Width="325px"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td class="auto-style25" colspan="2">
                <asp:Button ID="btn_iletisim" runat="server" CssClass="auto-style13" OnClick="btn_iletisim_Click" Text="Gönder" Width="509px" />
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td class="auto-style25">
            <asp:Label ID="lbl_msg" runat="server" CssClass="auto-style26"></asp:Label>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </table>
</asp:Content>

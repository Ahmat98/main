<%@ Page Title="" Language="C#" MasterPageFile="~/indexSite.Master" AutoEventWireup="true" CodeBehind="uyeOl.aspx.cs" Inherits="EWebsite.uyeOl" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
    .auto-style22 {
        width: 638px;
        height: 459px;
        color: #000000;
            background-color: #99FF99;
        }
    .auto-style23 {
        text-align: center;
    }
    .auto-style24 {
        font-size: large;
    }
    .auto-style25 {
        width: 112px;
        text-align: center;
    }
    .auto-style26 {
        color: #3399FF;
    }
        .auto-style27 {
            background-color: #99FF66;
        }
        .auto-style28 {
            background-color: #99FF99;
        }
        .auto-style29 {
            text-align: center;
            text-decoration: underline;
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
            <h1 class="auto-style29">Üye Ol</h1>
        </td>
    </tr>
    <tr>
        <td class="auto-style25">Ad</td>
        <td class="auto-style23">
            <asp:TextBox ID="TextBox1" runat="server" CssClass="auto-style24" Width="300px"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="TextBox1" ErrorMessage="Adınızı girmelisiniz" ForeColor="#FF6666" Font-Size="X-Large">*</asp:RequiredFieldValidator>
                </td>
    </tr>
    <tr>
        <td class="auto-style25">Soyad</td>
        <td class="auto-style23">
            <asp:TextBox ID="TextBox2" runat="server" CssClass="auto-style24" Width="300px"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="TextBox2" ErrorMessage="Soadınızı girmelisiniz" ForeColor="#FF6666" Font-Size="X-Large">*</asp:RequiredFieldValidator>
                </td>
    </tr>
    <tr>
        <td class="auto-style25">Eposta</td>
        <td class="auto-style23">
            <asp:TextBox ID="TextBox3" runat="server" CssClass="auto-style24" Width="300px"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ControlToValidate="TextBox3" ErrorMessage="Epostanızı  girmelisiniz" ForeColor="#FF6666" Font-Size="X-Large">*</asp:RequiredFieldValidator>
                </td>
    </tr>
    <tr>
        <td class="auto-style25">Cinsiyet</td>
        <td class="auto-style23">
                    <asp:DropDownList ID="DropDownList1" runat="server" Height="33px" Width="302px" CssClass="auto-style24">
                        <asp:ListItem>Select  Gender</asp:ListItem>
                        <asp:ListItem>Male</asp:ListItem>
                        <asp:ListItem>Female</asp:ListItem>
                        <asp:ListItem>Other</asp:ListItem>
                    </asp:DropDownList>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ControlToValidate="DropDownList1" ErrorMessage="Cinsiyeti  girmelisiniz" ForeColor="#FF6666" Font-Size="X-Large">*</asp:RequiredFieldValidator>
                </td>
    </tr>
    <tr>
        <td class="auto-style25">Şifre</td>
        <td class="auto-style23">
            <asp:TextBox ID="TextBox4" runat="server" CssClass="auto-style24" Width="300px" TextMode="Password"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ControlToValidate="TextBox4" ErrorMessage="Şifrenizi  girmelisiniz" ForeColor="#FF6666" Font-Size="X-Large">*</asp:RequiredFieldValidator>
                </td>
    </tr>
    <tr>
        <td class="auto-style25">Tekrarla</td>
        <td class="auto-style23">
            <asp:TextBox ID="TextBox5" runat="server" CssClass="auto-style24" Width="300px" TextMode="Password"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" ControlToValidate="TextBox5" ErrorMessage="First Nmae is empty" ForeColor="#FF6666" Font-Size="X-Large">*</asp:RequiredFieldValidator>
                </td>
    </tr>
    <tr>
        <td class="auto-style23" colspan="2">
                    <asp:Button ID="Button1" runat="server" Text="Üye Ol" Width="173px" Font-Bold="True" Font-Size="Large" OnClick="Button1_Click" CssClass="auto-style26" />
                    &nbsp;&nbsp;
                    <asp:HyperLink ID="HyperLink1" runat="server" Font-Bold="True"  Font-Names="Comic Sans MS" BackColor="Silver" NavigateUrl="~/giris.aspx" Width="173px" CssClass="auto-style28">Login</asp:HyperLink>
                </td>
    </tr>
    <tr>
        <td class="auto-style23" colspan="2">
            <asp:ValidationSummary ID="ValidationSummary1" runat="server" CssClass="auto-style27" />
        </td>
    </tr>
    <tr>
        <td class="auto-style25">&nbsp;</td>
        <td class="auto-style23">
                    <asp:Label ID="Label1" runat="server" Text="" style="color: #FF3399"></asp:Label>
                </td>
    </tr>
</table>
</asp:Content>

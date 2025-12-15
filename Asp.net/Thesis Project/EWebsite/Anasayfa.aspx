<%@ Page Title="" Language="C#" MasterPageFile="~/indexSite.Master" AutoEventWireup="true" CodeBehind="Anasayfa.aspx.cs" Inherits="EWebsite.Anasayfa" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style type="text/css">
        .auto-style6 {
        }

        .auto-style7 {
            text-align: center;
        }

        .auto-style12 {
            width: 100%;
        }

        .auto-style13 {
            width: 227px;
        }

        .auto-style14 {
            color: #CC0099;
        }

        .auto-style15 {
            width: 1107px;
        }

        .auto-style21 {
            width: 1095px;
            height: 50px;
        }

        .auto-style22 {
            color: #000000;
        }

        .auto-style23 {
            background-color: #99FFCC;
        }

        .auto-style24 {
            background-color: #99FF99;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
   
    <asp:DataList ID="DataList1" runat="server" DataSourceID="AccessDataSource1" Height="293px" Width="310px" RepeatColumns="4" RepeatDirection="Horizontal" OnItemCommand="DataList1_ItemCommand">
        <ItemTemplate>
            <table>
                <tr>
                    <td style="text-align: center;" class="auto-style23">
                        <asp:Label ID="Label1" runat="server" Text='<%# Eval("urnAd") %>' Font-Bold="True" Font-Names="Open Sans Extrabold" ForeColor="White"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center">
                        <asp:Image ID="Image1" runat="server" BorderColor="#5F9BF3" BorderWidth="1px" Height="250px" Width="278px" ImageUrl='<%# Eval("urnResim") %>' />
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center;" class="auto-style24">
                        <asp:Label ID="Label2" runat="server" Text="Price" Font-Bold="True" Font-Names="Arial" ForeColor="White" Style="text-align: center"></asp:Label>
                        <asp:Label ID="Label3" runat="server" Text='<%# Eval("urnFiyat") %>' Font-Bold="True" Font-Names="Arial" ForeColor="White" Style="text-align: center"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td align="center">Quantity
                     <asp:DropDownList ID="DropDownList1" runat="server">
                         <asp:ListItem>1</asp:ListItem>
                         <asp:ListItem>6</asp:ListItem>
                         <asp:ListItem>12</asp:ListItem>
                         <asp:ListItem>50</asp:ListItem>
                         <asp:ListItem>100</asp:ListItem>
                     </asp:DropDownList>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center">
                        <asp:ImageButton ID="ImageButton1" runat="server" Height="40px"
                            ImageUrl="~/resim/spt.jpg" Width="160px" CommandArgument='<%# Eval("ID") %>' CommandName="AddToCart" />
                    </td>
                </tr>
            </table>
            <br />
            <br />

        </ItemTemplate>
    </asp:DataList>

    <asp:AccessDataSource ID="AccessDataSource1" runat="server" DataFile="~/App_Data/AlisverisSt.accdb" SelectCommand="SELECT * FROM [urun]"></asp:AccessDataSource>
</asp:Content>
<asp:Content ID="Content3" runat="server" ContentPlaceHolderID="ContentPlaceHolder2">
    <table class="auto-style12">
        <tr style="width: 100px; text-align: center">
            <td class="auto-style13">
                <table align="left" class="auto-style21">
                    <tr>
                        <td class="auto-style14" style="text-align: left">
                            <h1>myWebsite&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </h1>
                        </td>
                        <td>
                            <asp:TextBox Style="padding-bottom: 0px; margin-right: 0" ID="txtBul" runat="server" Width="302px" Height="30px"></asp:TextBox>
                        </td>
                        <td>
                            <asp:ImageButton ID="ibtnbul" runat="server" Height="28px" ImageUrl="~/resim/search.jpg" Width="45px" OnClick="ibtnbul_Click" />
                        </td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <asp:ImageButton ID="ImageButton8" runat="server" Height="28px" ImageUrl="~/resim/5771782.png" Width="45px" />&nbsp;&nbsp;
                            <asp:ImageButton ID="ImageButton7" runat="server" Height="28px" ImageUrl="~/resim/3689123.png" Width="45px" />&nbsp;&nbsp;
                            <asp:ImageButton ID="ImageButton6" runat="server" Height="28px" ImageUrl="~/resim/229098.png" Width="45px" />&nbsp;&nbsp;<asp:ImageButton ID="btn_Spt" runat="server" Height="28px" ImageUrl="~/resim/950812.png" Width="45px" OnClick="btn_Spt_Click" />

                        </td>
                    </tr>
                </table>
                &nbsp;&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</asp:Content>

<asp:Content ID="Content4" runat="server" ContentPlaceHolderID="ContentPlaceHolder3">
    <asp:Label ID="lblKullanici" runat="server" CssClass="auto-style22"></asp:Label>
</asp:Content>

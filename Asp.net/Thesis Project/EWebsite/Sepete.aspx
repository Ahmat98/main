<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Sepete.aspx.cs" Inherits="EWebsite.Sepete" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">

        .auto-style1 {
            color: #66CCFF;
            text-align: center;
        }

        .auto-style2 {
            font-size: x-large;
        }

        .auto-style3 {
            font-size: x-large;
            font-weight: bold;
            background-color: #0066FF;
        }


        </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
    <h1 class="auto-style1">Sepetinizde Takip Edilen Ürün Var</h1>
        <div align="center">
            <asp:HyperLink ID="HyperLink1" runat="server" BorderWidth="0px" CssClass="auto-style2" Font-Bold="True" Font-Names="Colonna MT" Font-Overline="False" NavigateUrl="~/Anasayfa.aspx">Alısverise devam</asp:HyperLink>
            <br />
            <br />
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" BackColor="#99FF66" BorderColor="Black" BorderStyle="Solid" BorderWidth="5px" EmptyDataText="No Product Available İn Shopping Cart" Font-Bold="True" Height="270px" ShowFooter="True" Width="1100px" OnRowDeleting="GridView1_RowDeleting">
                <Columns>
                    <asp:BoundField DataField="sno" HeaderText="Sr No">
                        <ItemStyle HorizontalAlign="Center" />
                    </asp:BoundField>
                    <asp:BoundField DataField="pid" HeaderText="Ürün ID">
                        <ItemStyle HorizontalAlign="Center" />
                    </asp:BoundField>
                    <asp:ImageField HeaderText="Ürünün Resmi" DataImageUrlField="pimage">
                        <ControlStyle Height="300px" Width="340px" />
                        <ItemStyle HorizontalAlign="Center" />
                    </asp:ImageField>
                    <asp:BoundField DataField="pname" HeaderText="Ürünün Adı">
                        <ItemStyle HorizontalAlign="Center" />
                    </asp:BoundField>
                    <asp:BoundField DataField="pprice" HeaderText="Fiyat">
                        <ItemStyle HorizontalAlign="Center" />
                    </asp:BoundField>
                    <asp:BoundField DataField="pquantity" HeaderText="Adet">
                        <ItemStyle HorizontalAlign="Center" />
                    </asp:BoundField>
                    <asp:BoundField DataField="ptotalprice" HeaderText="Toplam Fiyatı">
                        <ItemStyle HorizontalAlign="Center" />
                    </asp:BoundField>
                    <asp:CommandField DeleteText="Remove" ShowDeleteButton="True" />
                </Columns>
                <FooterStyle BackColor="#CCFFFF" />
                <HeaderStyle BackColor="#3399FF" ForeColor="White" />
            </asp:GridView>
            <br />
            <strong><em>
                <asp:Button ID="Button1" runat="server" BorderStyle="Solid" CssClass="auto-style3" Text="Sipariş Vermek" OnClick="Button1_Click" />
            </em></strong>
        </div>
        </div>
    </form>
</body>
</html>

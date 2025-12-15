using System;
using System.Collections.Generic;
using System.Data.OleDb;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EWebsite
{
    public partial class Anasayfa : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Session["addproduct"] = "false";
            if (Session["Kullanici"] != null)
            {
                lblKullanici.Text = "Welcome: " + Session["Kullanici"].ToString();

            }
            else
            {

                lblKullanici.Text = "Giriş Yap";
            }
        }

        protected void DataList1_ItemCommand(object source, DataListCommandEventArgs e)
        {
            Session["addproduct"] = "true";
            if (e.CommandName == "AddToCart")
            {
                DropDownList list = (DropDownList)(e.Item.FindControl("DropDownList1"));
                Response.Redirect("Sepete.aspx?id=" + e.CommandArgument.ToString() + "&quantity=" + list.SelectedItem.ToString());
            }
        }

        protected void btn_Spt_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Sepete.aspx");
        }

        protected void ibtnbul_Click(object sender, ImageClickEventArgs e)
        {
            String BaglantiYolu = "Provider=Microsoft.ACE.OLEDB.12.0; data source=|DataDirectory|AlisverisSt.accdb";
            OleDbConnection Baglanti = new OleDbConnection(BaglantiYolu);
            Baglanti.Open();
            string Sorgu = "SELECT * FROM urun WHERE urnAd LIKE '" + txtBul.Text + "%'";
            OleDbCommand Komut = new OleDbCommand(Sorgu, Baglanti);
            OleDbDataReader Okuyucu = Komut.ExecuteReader();
            DataList1.DataSourceID = null;
            DataList1.DataSource = Okuyucu;
            DataList1.DataBind();
            Baglanti.Close();
            Komut.Dispose();
            Okuyucu.Close();
            Baglanti.Close();
            Komut.Dispose();
            Okuyucu.Close();
        }
    }
}
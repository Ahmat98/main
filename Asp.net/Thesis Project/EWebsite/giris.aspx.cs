using System;
using System.Collections.Generic;
using System.Data.OleDb;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EWebsite
{
    public partial class giris : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btngiris_Click(object sender, EventArgs e)
        {
            OleDbConnection Baglanti = new OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0; data source=" + Server.MapPath("App_Data\\AlisverisSt.accdb"));
            Baglanti.Open();
            String eposta = txt_kullanici.Text;
            String sifre = txt_sifre.Text;
            OleDbCommand Komut = new OleDbCommand("SELECT * from uyeler WHERE eposta='" + eposta + "' and sifre='" + sifre + "'", Baglanti);
            OleDbDataReader Okuyucu = Komut.ExecuteReader();

            if (Okuyucu.Read())
            {
                Session.Add("Kullanici", eposta);
                Response.Redirect("Anasayfa.aspx");
            }
            else
            {
                lbl_msg.Text = "giriş başarısız";
            }
            Baglanti.Close();
            Baglanti.Dispose();
        }
    }
}
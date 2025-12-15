using System;
using System.Collections.Generic;
using System.Data.OleDb;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EWebsite
{
    public partial class iletisim : System.Web.UI.Page
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

        protected void btn_iletisim_Click(object sender, EventArgs e)
        {
            String BaglantiYolu = "Provider=Microsoft.ACE.OLEDB.12.0; data source=|DataDirectory|AlisverisSt.accdb";
            OleDbConnection Baglanti = new OleDbConnection(BaglantiYolu);
            Baglanti.Open();
            string ad = TextBox1.Text;
            string soyad = TextBox2.Text;
            string ulke = DropDownList1.Text;
            string konu = TextBox3.Text;

            string Sorgu = "INSERT INTO iletisim(ad, soyad, ulke, konu) VALUES (@ad, @soyad, @ulke, @konu)";
            OleDbCommand Komut = new OleDbCommand(Sorgu, Baglanti);
            Komut.Parameters.AddWithValue("@ad", ad);
            Komut.Parameters.AddWithValue("@soyad", soyad);
            Komut.Parameters.AddWithValue("@ulke", ulke);
            Komut.Parameters.AddWithValue("@konu", konu);


            //Label1.Enabled = true; 
            //Label2.Text = "kayit yapilmistir"; 
            // GridView1.Visible = true; 
            Komut.ExecuteNonQuery();
            Baglanti.Close();
            lbl_msg.Text = "Mesajınız başarıyla gönderilmiştir";
        }
    }
}
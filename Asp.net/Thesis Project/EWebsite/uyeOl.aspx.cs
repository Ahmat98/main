using System;
using System.Collections.Generic;
using System.Data.OleDb;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EWebsite
{
    public partial class uyeOl : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            String BaglantiYolu = "Provider=Microsoft.ACE.OLEDB.12.0; data source=|DataDirectory|AlisverisSt.accdb";
            OleDbConnection Baglanti = new OleDbConnection(BaglantiYolu);
            Baglanti.Open();
            string ad = TextBox1.Text;
            string soyad = TextBox2.Text;
            string eposta = TextBox3.Text;
            string cinsiyet = DropDownList1.Text;
            string sifre = TextBox4.Text;

            string Sorgu = "INSERT INTO uyeler(ad, soyad, eposta, cinsiyet, sifre) VALUES (@ad, @soyad, @eposta, @cinsiyet, @sifre)";
            OleDbCommand Komut = new OleDbCommand(Sorgu, Baglanti);
            Komut.Parameters.AddWithValue("@ad", ad);
            Komut.Parameters.AddWithValue("@soyad", soyad);
            Komut.Parameters.AddWithValue("@eposta", eposta);
            Komut.Parameters.AddWithValue("@cinsiyet", cinsiyet);
            Komut.Parameters.AddWithValue("@sifre", sifre);


            Komut.ExecuteNonQuery();
            Baglanti.Close();
            Label1.Text = "Register successfully";
        }
    }
}
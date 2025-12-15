using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EWebsite
{
    public partial class Hakkımızda : System.Web.UI.Page
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
    }
}
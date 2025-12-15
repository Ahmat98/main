using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EWebsite
{
    public partial class indexSite : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Timer2_Tick(object sender, EventArgs e)
        {
            Random rnd = new Random();
            int i = rnd.Next(1, 5);
            Image2.ImageUrl = "~/resim/" + "rek" + i.ToString() + ".jpg";
        }
    }
}
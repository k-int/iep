
<html>
    <head>
        <title>IEP - Information Enhancement Portal</title>
        <link type="text/css" rel="stylesheet" href="http://yui.yahooapis.com/3.3.0/build/cssfonts/fonts-min.css" /> 
        <script src="http://yui.yahooapis.com/3.3.0/build/yui/yui-min.js" charset="utf-8"></script>
        <meta name="layout" content="main" />
    </head>
    <body>

      <g:if test="${userAuthorities.size() > 0}">
        <h2>Record Authorities You Manage</h2>
        <div id="authdatatable"></div>
      </g:if>

      <script language="JavaScript">
        YUI().use("datatable-scroll", function (Y) {
          var authdata= [
            <g:each status="s" in="${userAuthorities}" var="ua">
              <g:if test="${s>0}">,</g:if>{ 'IC':'<a href="/iep/authority/${ua.identifier}">${ua.identifier}</a>','SC':'${ua.shortCode}','NM':'${ua.name}' }
            </g:each>
          ];

          // Create a DataTable that scrolls vertically
          var dtScrollingY = new Y.DataTable.Base({
            columnset: [
              {key:"IC", label:"Internal Code  "},
              {key:"SC", label:"Short(URL) Code"},
              {key:"NM", label:"Name",}
            ],
            recordset: authdata,
            summary: "Managed Record Authorties",
            width: '100%'
          });

          dtScrollingY.plug(Y.Plugin.DataTableScroll, {
              height:"200px",
              width:"100%"
          });

          dtScrollingY.render("#authdatatable");
        });
      </script>
    </body>
</html>


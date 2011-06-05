
<html>
    <head>
        <title>IEP - Information Enhancement Portal</title>
        <meta name="layout" content="main" />
    </head>
    <body>

      <g:if test="${userAuthorities.size() > 0}">
        <div>
          This section lists any authorities the user is granted permission to manage, and links to the authority home page. It's only shown if there are rows.
          <table>
            <g:each status="s" in="${userAuthorities}" var="ua">
              <tr>
                <td> <a href="${ua.identifier}">${ua.identifier}</a> </td>
                <td> ${ua.shortCode}</td>
                <td> ${ua.name}</td>
              </tr>
            </g:each>
          </table>
        </div>
      </g:if>

      <div>
         This section lists any individual records the user has adopted
      </div>
    </body>
</html>


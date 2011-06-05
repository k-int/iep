<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}">
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.3.0/build/cssgrids/grids-min.css">
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
      <body class="yui3-skin-sam  yui-skin-sam">
        <div id="iepheader" class="yui3-g">
          <div class="yui3-u" style="width:100%">
            <div style="float:right;">Welcome back ${user.username}</div>
            <div>Open Family Services - Information Management and Enhancement Portal</div>
          </div>
        </div>

        <div class="yui3-g" id="iepmainlayout">

          <div id="iepnav" class="yui3-u">
            Navigation 
          </div>

          <div id="iepmain" class="yui3-u">
            <g:layoutBody />
          </div>
        </div>

        <div id="iepfooter" class="yui3-g">
        </div>
    </body>
</html>

/*create time 2014-1-03 by yangbo*/
var XMLHttpJans, everyID, XMLHttp;
var showContentID;
var hiddenContentID;
function CreateAndSendXMLHttp(url)
{
    createXMLHttp();
    XMLHttp.open("POST",url,false);
    XMLHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    XMLHttp.send(null);
    return XMLHttp.responseText;
}
function createXMLHttp()
{
    if (window.XMLHttpRequest)
    {
        XMLHttp = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        XMLHttp = new ActiveXObject("Microsoft.XMLHttp");
    }
    else if (window.ActiveXObject)
    {
        XMLHttp = new ActiveXObject("Msxml2.XMLHTTP.4.0");
    }
    else if (window.ActiveXObject)
    {
        XMLHttp = new ActiveXObject("Msxml2.XMLHTTP");
    }
}

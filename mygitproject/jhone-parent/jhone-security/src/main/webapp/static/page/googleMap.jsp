<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" session="false" %> 
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
  <meta http-equiv="Content-Language" content="text/html; charset=UTF-8">
 <style type="text/css">
		v\:* {
	  behavior:url(#default#VML);
	}
	tt01 {font-size:11pt;color:#697335;font-weight:bold;}
	</style>
    <script src="http://maps.google.com/maps?file=api&v=2&key=AIzaSyCHV8c9Xzm0wrlPOSrLlIdY29TiIAyzUtg" type="text/javascript"></script>
 <script type="text/javascript">
 //<![CDATA[ 
		function load() {
		  if (GBrowserIsCompatible()) {
		    var map = new GMap2(document.getElementById("map"));
		    map.addControl(new GLargeMapControl());
		    map.addControl(new GMapTypeControl());
		    map.addControl(new GScaleControl());
			map.setCenter(new GLatLng(39.9,116.4), 13, G_SATELLITE_MAP); 
			GDownloadUrl("BeiJing.xml", function(data, responseCode) {
				var xml = GXml.parse(data);
				var markers00 =xml.getElementsByTagName("marker"); 
				map.openInfoWindow(map.getCenter(),document.createTextNode(markers00.length));
				for (var i = 0; i < markers00.length; i++) {
					var point = new GLatLng(parseFloat(markers00[i].getAttribute("lat")),
                            parseFloat(markers00[i].getAttribute("lng")));
					map.addOverlay(new GMarker(point));
				}		
			});

	      }
		}
	//]]>
 var geocoder; 
  var map; 
  function initialize() { 
    geocoder = new google.maps.Geocoder(); 
    var latlng = new google.maps.LatLng(31.23, 121.47); 
    var myOptions = { 
      zoom: 12, 
      center: latlng, 
      mapTypeId: google.maps.MapTypeId.ROADMAP 
    } 
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions); 
  } 
	 function codeAddress() { 
    var address = document.getElementById("address").value; 
    geocoder.geocode( { 'address': address}, function(results, status) { 
      if (status == google.maps.GeocoderStatus.OK) { 
        console.log(results[0].geometry.location) 
        map.setCenter(results[0].geometry.location); 
        this.marker = new google.maps.Marker({ 
                title:address, 
            map: map,  
            position: results[0].geometry.location 
        }); 
                var infowindow = new google.maps.InfoWindow({ 
                    content: '<strong>'+address+'</strong><br/>'+'纬度: '+results[0].geometry.location.Da+'<br/>经度: '+results[0].geometry.location.Ea 
                }); 
                infowindow.open(map,marker); 
      } else { 
        alert("Geocode was not successful for the following reason: " + status); 
      } 
    }); 
  } 
	
	
	</script>
	</head>
 <body align="center" bgcolor= "#A0AA6D" onload="load()">
	 <form action="#" id ="myform">
	 	<lable>请输入要查询的地方</lable>
	 	<input type="text" name="address" value="" id="address"/>
	 	<input type="button" value="地址解析" onclick="codeAddress()"> 
	 </form>
  <table width=90% border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td><div id="map" style="width: 700px; height: 560px" align="center"></div></td>  
  </tr>
  </table>
  <div id="map_canvas" style="width: 700px; height: 560px"></div>
  </body>
  </html>
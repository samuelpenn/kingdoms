<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<r:require modules="jquery"/>
<title>${player.name}</title>
</head>

<body>

	<g:javascript>
		$(document).ready(function() {
			// $("#map").html("Loading...");
			
			$.ajax({
				type: "GET",
				dataType: "json",
				url: "/Kingdoms/api/player/1/look",
				success: function (data) {
					[ "nw", "n", "ne", "w", "origin", "e", "sw", "s", "se" ].forEach(function(loc) {
						if (data.map[loc] != null) {
							var img = "/Kingdoms/images/tiles/" + data.map[loc].image + ".png";
							$("#loc_" + loc).css("background-image", "url(" + img + ")");
						}
					});
				}
			});
			
		});
	</g:javascript>
	
	<div id="header">
		<h1>${player.name }</h1>
	</div>
	
	<div id="map">
		<table>
			<tr>
				<td class="loc" id="loc_nw"></td>
				<td class="hpad"></td>
				<td class="loc" id="loc_n"></td>
				<td class="hpad"></td>
				<td class="loc" id="loc_ne"></td>
			</tr><tr>
				<td class="vpad"></td>
				<td class="block"></td>
				<td class="vpad"></td>
				<td class="block"></td>
				<td class="vpad"></td>
			</tr>
			<tr>
				<td class="loc" id="loc_w"></td>
				<td class="hpad"></td>
				<td class="loc" id="loc_origin"></td>
				<td class="hpad"></td>
				<td class="loc" id="loc_e"></td>
			</tr>
			<tr>
				<td class="vpad"></td>
				<td class="block"></td>
				<td class="vpad"></td>
				<td class="block"></td>
				<td class="vpad"></td>
			</tr>
			<tr>
				<td class="loc" id="loc_sw"></td>
				<td class="hpad"></td>
				<td class="loc" id="loc_s"></td>
				<td class="hpad"></td>
				<td class="loc" id="loc_se"></td>
			</tr>
		</table>
	</div>

</body>

</html>
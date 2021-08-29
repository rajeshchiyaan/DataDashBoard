<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript">
window.onload = function() {
 
var dps = [[], [], [], [],[],[]];
var chart = new CanvasJS.Chart("skillSetContainer", {
	animationEnabled: true,
	title:{
		text: "Employees Skill Sets"
	},
	toolTip: {
		shared: true,
		reversed: true
	},
	legend: {
		reversed: true,
		cursor: "pointer",
		itemclick: toggleDataSeries
	},
	axisY: {
		title: "Number of Employees"
	},
	data: [{
		type: "stackedColumn",
		name: "JAVA",
		showInLegend: true,
		yValueFormatString: "#,##0 employees",
		dataPoints: dps[0]
	},{
		type: "stackedColumn",
		name: "AI",
		showInLegend: true,
		yValueFormatString: "#,##0 employees",
		dataPoints: dps[1]
	},{
		type: "stackedColumn",
		name: "PYTHON",
		showInLegend: true,
		yValueFormatString: "#,##0 employees",
		dataPoints: dps[2]
	},{
		type: "stackedColumn",
		name: "SPRING",
		showInLegend: true,
		yValueFormatString: "#,##0 employees",
		dataPoints: dps[3]
	},
	{
		type: "stackedColumn",
		name: "SELENIUM",
		showInLegend: true,
		yValueFormatString: "#,##0 employees",
		dataPoints: dps[4]
	},
	{
		type: "stackedColumn",
		name: "OTHER SKILLS",
		showInLegend: true,
		yValueFormatString: "#,##0 employees",
		dataPoints: dps[5]
	}]
});
 
function toggleDataSeries(e){
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	}
	else{
		e.dataSeries.visible = true;
	}
	chart.render();
}
 
var yValue;
var label;
 
<c:forEach items="${skillSetDataList}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
		yValue = parseFloat("${dataPoint.y}");
		label = "${dataPoint.label}";
		dps[parseInt("${loop.index}")].push({
			label : label,
			y : yValue
		});		
	</c:forEach>	
</c:forEach> 
 
chart.render();
 
	 
	var dps = [[]];
	var chart = new CanvasJS.Chart("chartContainer", {
		animationEnabled: true,
		title:{
			text: "Employees"
		},
		toolTip: {
			shared: true,
			reversed: true
		},
		legend: {
			reversed: true,
			cursor: "pointer",
			itemclick: toggleDataSeries
		},
		axisY: {
			title: "Number of Employees"
		},
		data: [{
			type: "stackedColumn",
			name: "Employees",
			showInLegend: true,
			yValueFormatString: "#,##0 employees",
			dataPoints: dps[0]
		}]
	});
	 
	function toggleDataSeries(e){
		if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
			e.dataSeries.visible = false;
		}
		else{
			e.dataSeries.visible = true;
		}
		chart.render();
	}
	 
	var yValue;
	var label;
	 
	<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
		<c:forEach items="${dataPoints}" var="dataPoint">
			yValue = parseFloat("${dataPoint.y}");
			label = "${dataPoint.label}";
			dps[parseInt("${loop.index}")].push({
				label : label,
				y : yValue
			});		
		</c:forEach>	
	</c:forEach> 
	 
	chart.render();
	 
	}  
</script>



</head>
<body>
	<div id="chartContainer" style="height: 300px; width: 50%;"></div> 
	<div id="skillSetContainer" style="height: 300px; width: 50%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
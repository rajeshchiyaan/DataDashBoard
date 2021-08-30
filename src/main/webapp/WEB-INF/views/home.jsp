<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee DashBoard</title>


<script type="text/javascript">
window.onload = function() {

<!--  Skills Sets -->
 
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
 
<!-- Employees Data -->
	 
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

<!--  Tfactor Hyderabad -->

	var dps = [[]];
	var chart = new CanvasJS.Chart("tfactorHyd", {
		theme: "light2", // "light1", "dark1", "dark2"
		animationEnabled: true,
		title: {
			text: "T-Factor Hyderabad"
		},
		data: [{
			type: "pie",
			showInLegend: "true",
			legendText: "{label}",
			yValueFormatString: "#,##0.0#\"%\"",
			indexLabelFontSize: 16,
			indexLabel: "{label} - {y}",
			dataPoints: dps[0]
		}]
	});
	 
	var yValue;
	var label;
	 
	<c:forEach items="${hydTfDataList}" var="dataPoints" varStatus="loop">	
		<c:forEach items="${dataPoints}" var="dataPoint">
			yValue = parseFloat("${dataPoint.y}");
			label = "${dataPoint.label}";
			dps[parseInt("${loop.index}")].push({
				label : label,
				y : yValue,
			});		
		</c:forEach>	
	</c:forEach> 
	 
	chart.render();
	
	<!--  Tfactor Chennai -->

	var dps = [[]];
	var chart = new CanvasJS.Chart("tfactorCh", {
		theme: "light2", // "light1", "dark1", "dark2"
		animationEnabled: true,
		title: {
			text: "T-Factor Chennai"
		},
		data: [{
			type: "pie",
			showInLegend: "true",
			legendText: "{label}",
			yValueFormatString: "#,##0.0#\"%\"",
			indexLabelFontSize: 16,
			indexLabel: "{label} - {y}",
			dataPoints: dps[0]
		}]
	});
	 
	var yValue;
	var label;
	 
	<c:forEach items="${chTfDataList}" var="dataPoints" varStatus="loop">	
		<c:forEach items="${dataPoints}" var="dataPoint">
			yValue = parseFloat("${dataPoint.y}");
			label = "${dataPoint.label}";
			dps[parseInt("${loop.index}")].push({
				label : label,
				y : yValue,
			});		
		</c:forEach>	
	</c:forEach> 
	 
	chart.render();
	
	 
	}  
</script>


</head>
<body>
<div align="center"><h1><b><i>Dashboard Template</i></b></h1></div>
<div align="center" style="width: 790px;height: 500px;float: left;">
	<div id="chartContainer" style="height: 250px; width: 70%;"></div> <br/><br/>
	<div id="skillSetContainer" style="height: 250px; width: 70%;"></div>
</div>
<div align="center" style="width: 500px;height: 500px;float: right;">
	 <div id="tfactorHyd" style="height: 250px; width: 70%;"></div><br/><br/>
	<div id="tfactorCh" style="height: 250px; width: 70%;"></div> 
</div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
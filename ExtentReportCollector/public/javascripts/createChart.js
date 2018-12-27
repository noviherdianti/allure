function createChart(chartData){
  var percentage = chartData.pass * 100 / (chartData.pass + chartData.fail + chartData.warning + chartData.error);
	$(function() {
        var chart = new Highcharts.Chart({
          chart: {
              renderTo: 'container',
              plotBackgroundColor: null,
              plotBorderWidth: null,
              plotShadow: false,
              type: 'pie'
          },
          title: {
              text: percentage.toFixed(2) + "%",
              align: 'center',
              verticalAlign: 'middle',
              fontSize: '20px',
          },
          plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.2f} %',
                        style: {
                            <!--color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'-->
                            color: (Highcharts.theme)
                        }
                    }
                }
          },
          tooltip: {
                pointFormat: '{series.name}: <b>{point.y}</b>'
          },
          exporting: {
            enabled: false
          },
          credits: {
            enabled: false
          },
          series: [{
                name: 'Brands',
                colorByPoint: true,
                data: [{
                    name: 'Pass',
                    y: chartData.pass,
                    color: '#97cc64'
                }, {
                    name: 'Fail',
                    y: chartData.fail,
                    color: '#fd5a3e'
                }, {
                    name: 'Pending',
                    y: chartData.warning,
                    color: '#d35ebe'
                }, {
                    name: 'Error',
                    y: chartData.error,
                    color: '#EDD332'
                }],
                size: '75%',
                innerSize: '75%',
            }]
        });
    });
}
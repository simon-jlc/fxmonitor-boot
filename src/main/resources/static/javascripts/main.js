/**
 * New node file
 */
(function() {

	// no dependancies
	var app = angular.module('fxmonitor', [
		'trNgGrid',
		'ui.bootstrap',
		'ui.filters',
		'ui.components',
	    'ui.alerts.ctrl',
	    'jobs-directives',
	    'jobs-module'
    ]);
	
	app.controller('OverviewController', ['$scope', '$http', '$log', function($scope, $http, $log) {
		
		var oc = this;
		
		// boolean to display or not
		oc.loading = 0;
		oc.categories = [];
		
		
		//
		$scope.loadStatisticsByCategory = function(projectId) {
			oc.loading = 1;
			oc.categories = [];
			
			// do the asynch request
			$http({
				url: 'api/stats/categories/' + projectId,
				method: 'GET',
				headers: {
					"Content-type":"application/json"
				},
				responseType: 'json'
			}).success(function(data) {
				
				// TODO: optimiser les appels serveurs avec une map
				// <IdProject, StatsCategories List>
//				var details = {
//					projectId: projectId,
//					categories: data
//				}

				angular.forEach(data, function(item) {
					$log.info("name=" + item.name);
					$log.info("success=" + item.success);
					$log.info("warnings=" + item.warnings);
					$log.info("errors=" + item.errors);
					$log.info("-----------------");
					
					this.push(item);
				}, oc.categories);

				// set loader to 0
				oc.loading = 0;
				
			}).error(function(data) {
				// update alert msg with danger type
				// TODO do somethng when error
			
			});
		};
	}]);
})();
/**
 * New node file
 */
(function() {

	var alerts = angular.module('ui.alerts.ctrl', ['ui.bootstrap']);
	
	// define alert components
	alerts.controller('AlertCtrl', function($scope) {
		
		// variables alerts array
		$scope.alerts = [];
		
		// alert function
		$scope.addOrUpdateAlert = function(type, msg) {
			if ($scope.alerts.length > 0) {
				// update index 0
				$scope.alerts[0] = {
					type: type,
					msg: msg
				};
			} else {
				// add alerts
				$scope.alerts.push({
			    	type: type,
			    	msg: msg
			    });
			}
		};
		
		$scope.closeAlert = function(index) {
			$scope.alerts.splice(index, 1);
		};
		
	});
	
	// add directives for html component
	alerts.directive("uiAlerts", function() {
		return {
			restrict : 'E',
			templateUrl : "/partial/ui-alerts.html",
			controllerAs : "AlertCtrl"
		};
	});
})();
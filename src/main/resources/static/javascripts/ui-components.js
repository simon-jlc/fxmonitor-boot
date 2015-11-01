/**
 * New node file
 */

(function() {
	var uiComponents = angular.module('ui.components', []);

	uiComponents.controller("UiController", [ '$scope', '$log', 'filterFilter', function($scope, $log, filterFilter) {		
		
		// define model
		$scope.success = {status: "Success", total: this.totalErrors, faClass: "fa-check",panelColor: "panel-green"};
		$scope.warning = {status: "Warning", total: this.totalWarning, faClass: "fa-exclamation-triangle",panelColor: "panel-yellow"};
		$scope.error = {status: "Error", total: this.totalErrors, faClass: "fa-bomb",panelColor: "panel-red"};
		
		$scope.$watch("jobs", function(newJobs,oldJobs) {
			// configure the well
			// display scope.jobs value when setted

			if(typeof oldJobs === 'undefined' && typeof newJobs !== 'undefined') {
				$scope.error.total = filterFilter($scope.jobs, 'Failed').length;
				$scope.success.total = filterFilter($scope.jobs, 'Success').length;
				$scope.warning.total = filterFilter($scope.jobs, 'In Progress').length;
			}
		});
	}]);
	
	uiComponents.directive("uiWells", function() {
		return {
			restrict : 'E',
			templateUrl : "/partial/ui-wells.html",
			scope : {
				wellType: '='
			},
			controllerAs : "uiwells"
		};
	});
	
	uiComponents.controller("UiDatePicker", ['$scope', '$log', function($scope, $log) {
		
		// date picker function from http://angular-ui.github.io/bootstrap/#/datepicker 
		$scope.today = function() {
	    	$scope.dt = new Date();
		};
		
		$scope.clear = function() {
			$scope.dt = null;
		};

		// Disable weekend selection
//		$scope.disabled = function(date, mode) {
//			return (mode === 'day' && (date.getDay() === 0 || date
//					.getDay() === 6));
//		};

//		$scope.toggleMin = function() {
//			$scope.minDate = $scope.minDate ? null
//					: new Date();
//		};

		$scope.open = function($event) {
			$event.preventDefault();
			$event.stopPropagation();

			$scope.opened = true;
		};

		$scope.dateOptions = {
			formatYear : 'yy',
			startingDay : 1
		};

		// init controller
		$scope.today();
//		$scope.toggleMin();
		
//		$scope.formats = [ 'dd-MMMM-yyyy','yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate' ];
		$scope.format = 'dd/MM/yy hh:mm:ss';
		
		$scope.dateFrom = "dateFrom";
		$scope.dateTo = "dateTo";
		
//		this.id = $scope.elemId;
//		$log.info("[UiDatePicker] from controller element id: " + this.id);
//		$log.info("[UiDatePicker] from scope element id: " + $scope.elemid);
	}]);
	
	uiComponents.directive("uiDate", function() {
		return {
			restrict : 'E',
//			scope : {
//				elemId: '='
//			},
			templateUrl : "/partial/ui-date.html"
		};
	});

})();
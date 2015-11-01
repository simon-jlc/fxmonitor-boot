/**
 * New node file
 */
(function() {

	// no dependancies
	var app = angular.module('jobs-module', []);

	app.controller('JobsController', [ '$scope', '$http', '$log', function($scope, $http, $log) {
		var jobController = this;
		
		// variable to show or not the filter panel
		$scope.isCollapsed = true;
		
		// jobs filters scope variables
		$scope.filters = [{
			jobIds: [],
			linkedIds: [],
			categories: []
		}];
		
		// variable for JobPanel displaying one job only
		jobController.jobPanel = { 
				show: false,
				currentJob: null
		};
		
		// Add JSON call to populate jobs array when starting
		$http({
			url:'api/jobs',
			dataType: 'json',
			method: 'GET',
			headers: {
				"Content-type":"application/json"
			},
			responseType: 'json'
		}).success(function(data) {
			jobController.jobs = data;
			$scope.jobs = data;
		});
		
		// functions
		$scope.loadJobDetails = function(jobId) {
			
			$log.info("[JobsController] loadJobDetails(" + jobId + ")")
			
			// do the asynch request
			$http({
				url: 'api/jobs/' + jobId,
				method: 'GET',
				headers: {
					"Content-type":"application/json"
				},
				responseType: 'json'
			}).success(function(data) {
				$log.info("[JobsController] loadJobDetails messages size = " + data.messages.length);
				jobController.jobPanel.currentJob = data;
				jobController.jobPanel.show = true;
				$("body").animate({scrollTop: $("job-panel").offset().top}, "slow");
			}).error(function(data) {
				// update alert msg with danger type
				// TODO do somethng when error
			});
		};
		
		$scope.toDisplayName = function(strArray) {
			var result = [];
			if(angular.isArray(strArray)) {
				angular.forEach(strArray, function(item) {
					// keep object name only
					result.push(item.name);
				});
				
				return result.join();
			}
			
			return "Parameter strArray=" + strArray + " is not an array.";
		};
		
		var doActionFromJobsItem = function(actionUrl) {
			// display alerts or progress bar
			$scope.addOrUpdateAlert('info', 'Request in progress');
			
			// Link with trNgGrid table input
			var ids = [];
			
			angular.forEach(jobController.jobs, function(job) {
				if(job.selected){
					ids.push({
						ids: job.id
					})
				} 
			}, ids);
			
			// do the asynch request
			$http({
				url: actionUrl,
				dataType: 'json',
				method: 'POST',
				data: ids,
				headers: {
					"Content-type":"application/json"
				},
				responseType: 'json'
			}).success(function(data) {
				// update alert msg with succes type
				$scope.addOrUpdateAlert(data.type, data.msg);
			}).error(function(data) {
				// update alert msg with danger type
				$scope.addOrUpdateAlert(data.type, data.msg);
			});
		};
		
		
		$scope.doRelaunchJobs = function() {
			doActionFromJobsItem('api/jobs/relaunch');
		};
		
		$scope.doResolveJobs = function() {	
			doActionFromJobsItem('api/jobs/resolve');
		};
		
		$scope.checkAll = function () {
	        if ($scope.selectedAll) {
	            $scope.selectedAll = true;
	        } else {
	            $scope.selectedAll = false;
	        }
	        
	        angular.forEach($scope.jobs, function (item) {
	            item.Selected = $scope.selectedAll;
	        });
	    };
	    
	    // TODO AUTO COMPLETE FILTERS SPLIT
	    $scope.removeTag = function(index){
 		   $scope.filters.categories.splice(index,1);
		}
	    
	    $scope.$watchCollection('filters.categories',function(val){
	        $log.info(val);
	    });
	    
	    $scope.loadProcess = function(val) {
	    	$log.info("[JobModule] loadProcess: " + val);
	    	
		    return $http({
		    	url: 'api/jobs/processes/' + val,
    			dataType: 'json',
    			method: 'GET',
    			headers: {
    				"Content-type":"application/json"
    			},
    			responseType: 'json'
		    }).then(function(response){
		    	return response.data;
//		    	return limitToFilter(response.data, 15);
	    	});
	    };
	}]);
})();
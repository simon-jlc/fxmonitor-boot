/**
 * New node file
 */
(function() {
	var app = angular.module('jobs-directives', []);

	app.directive("jobRow", function() {
		return {
			restrict : 'E',
			templateUrl : "/partial/job-row.html"
		};
	});
	
	app.directive("jobPanel", function() {
		return {
			restrict : 'E',
			templateUrl : "/partial/job-panel.html"
		};
	});
	
	app.directive("jobFilter", function() {
		return {
			restrict : 'E',
			templateUrl : "/partial/job-filters.html",
			controllerAs: "jobsCtrl"
		};
	});
	
	
	app.directive('autoComplete',['$http',function($http){
	    return {
		    restrict: 'AE',
		    scope:{
		    	selectedTags: '=model'
		    },
		    templateUrl: '/partial/autocomplete-template.html',
		    link: function(scope,elem,attrs){
		    	scope.suggestions=[];
		    	scope.selectedTags=[];
		    	scope.selectedIndex=-1; // currently selected suggestion index
		    	
		    	
		    	scope.search = function(){
		    		
		    		$http({
		    			url: 'api/jobs/categories/' + scope.searchText,
//		    			url: 'api/jobs/categories/' + scope.searchText,
		    			dataType: 'json',
		    			method: 'GET',
		    			headers: {
		    				"Content-type":"application/json"
		    			},
		    			responseType: 'json'
		    		}).success(function(data) {
		    			
		    			$(".dropdown-toggle").dropdown();
		    			
		    			if(data.indexOf(scope.searchText)===-1){
		    	             data.unshift(scope.searchText);
		    	         }
		    	         scope.suggestions=data;
		    	         scope.selectedIndex=-1;
		    		});
		    	}
		    	
		    	
		    	scope.checkKeyDown = function(event){
		    		   if(event.keyCode===40){// down key, increment
												// selectedIndex
		    		       event.preventDefault();
		    		       if(scope.selectedIndex+1 !== scope.suggestions.length){
		    		           scope.selectedIndex++;
		    		       }
		    		   }
		    		   else if(event.keyCode===38){ // up key, decrement
													// selectedIndex
		    		       event.preventDefault();
		    		       if(scope.selectedIndex-1 !== -1){
		    		           scope.selectedIndex--;
		    		       }
		    		   }
		    		   else if(event.keyCode===13){ // enter pressed
		    		       scope.addToSelectedTags(scope.selectedIndex);
	    		   	}
		    	}
		    	
		    	scope.addToSelectedTags = function(index){
		    	     if(scope.selectedTags.indexOf(scope.suggestions[index])===-1){
		    	         scope.selectedTags.push(scope.suggestions[index]);
		    	         scope.searchText='';
		    	         scope.suggestions=[];
		    	     }
		    	}
		    	
		    	scope.$watch('selectedIndex',function(val){
		    	     if(val!==-1) {
		    	          scope.searchText = scope.suggestions[scope.selectedIndex];
		    	      }
		    	});
		    }
	    }
	}]);
	
})();
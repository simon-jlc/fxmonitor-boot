/**
 * New node file
 */
(function() {
	
	var uiFilters = angular.module('ui.filters', []);
	
	uiFilters.filter("stringToNumber", function () {
	    return function (fieldValueUnused, item) {
	        return parseInt(item.id);
	    };
	});
	
	
})();
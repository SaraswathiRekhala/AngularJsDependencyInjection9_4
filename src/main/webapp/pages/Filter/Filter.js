Application.$controller("FilterPageController", ["$scope", "$filter", function($scope, $filter) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };

    var today = new Date();
    $scope.fullDate = $filter('date')(today, 'fullDate');
    $scope.longDate = $filter('date')(today, 'longDate');
    $scope.mediumDate = $filter('date')(today, 'mediumDate');
    $scope.shortDate = $filter('date')(today, 'shortDate');
    $scope.datePattern = $filter('date')(today, 'yyyy MMM, dd');
    $scope.anotherDate = $filter('date')(today, 'yyyy-MM-dd');
    $scope.uppercaseName = $filter('uppercase')("Hello Angularjs Inspection");
    $scope.lowercaseName = $filter('lowercase')("Hello Angularjs Inspection");

    $scope.textValue = "Custom Filter Check";
}]);
Application.$controller("IsolateScopePageController", ["$scope", function($scope) {
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


    $scope.rating1Change = function($event, $isolateScope, newVal, oldVal) {
        debugger
        if ($isolateScope.datavalue == '1') {
            $scope.Widgets.rating1.color = 'red'
        } else if ($isolateScope.datavalue == '2') {
            $scope.Widgets.rating1.color = 'blue'
        } else if ($isolateScope.datavalue == '3') {
            $scope.Widgets.rating1.color = 'blue'
        } else if ($isolateScope.datavalue == '4') {
            $scope.Widgets.rating1.color = 'green'
        } else if ($isolateScope.datavalue == '5') {
            $scope.Widgets.rating1.color = 'green'
        }
    };

}]);
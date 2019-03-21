Application.$controller("ApplyPageController", ["$scope", "$timeout", function($scope, $timeout) {
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

    $scope.currentDateTime = new Date();
    $scope.updatedtime = function() {
        $scope.currentDateTime = new Date();
    }

    $scope.button1Click = function($event, $isolateScope) {
        $scope.updatedtime();
    };


    $scope.button2Click = function($event, $isolateScope) {
        debugger
        $timeout(function() {
            $scope.$apply(function() {
                console.log("update Date clicked");
                $scope.currentDateTime = new Date();
            });
        }, 2000)
    };
}]);
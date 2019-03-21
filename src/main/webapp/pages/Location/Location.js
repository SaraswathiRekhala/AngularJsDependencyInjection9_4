Application.$controller("LocationPageController", ["$scope", "$location", function($scope, $location) {
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

    $scope.button1Click = function($event, $isolateScope) {
        debugger
        console.log($location.absUrl());
        $scope.Widgets.label1.caption = "Current URL: " + $location.absUrl()
    };

}]);

// Application.$controller('myUrl', function($scope, $location) {
//     debugger
//     console.log($location.absUrl());
//     $scope.Widgets.label1.caption = $location.absUrl();
// });
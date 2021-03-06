Application.run(function($rootScope) {
    "use strict";
    /* perform any action on the variables within this block(on-page-load) */
    $rootScope.onAppVariablesReady = function() {
        /*
         * variables can be accessed through '$rootScope.Variables' property here
         * e.g. $rootScope.Variables.staticVariable1.getData()
         */
    };

    /* perform any action on session timeout here, e.g clearing some data, etc */
    $rootScope.onSessionTimeout = function() {
        /*
         * NOTE:
         * On re-login after session timeout:
         * if the same user logs in(through login dialog), app will retain its state
         * if a different user logs in, app will be reloaded and user is redirected to respective landing page configured in Security.
         */
    };

    /*
     * This application level callback function will be invoked after the invocation of PAGE level onPageReady function.
     * Use this function to write common logic across the pages in the application.
     * activePageName : name of the page
     * activePageScope: scope of the page
     * $activePageEl  : page jQuery element
     */
    $rootScope.onPageReady = function(activePageName, activePageScope, $activePageEl) {

    };

    /*
     * This application level callback function will be invoked after a Variable receives an error from the target service.
     * Use this function to write common error handling logic across the application.
     * source:      Variable object or Widget Scope
     * errorMsg:    The error message returned by the target service. This message will be displayed through appNotification variable
     *              You can change this though $rootScope.Variables.appNotification.setMessage(YOUR_CUSTOM_MESSAGE)
     * xhrObj:      The xhrObject used to make the service call
     *              This object contains useful information like statusCode, url, request/response body.
     */
    $rootScope.onServiceError = function(source, errorMsg, xhrObj) {

    };
});

Application.controller("myCtrl", function($scope) {
    $scope.firstName = "Saraswathi";
    $scope.lastName = "Rekhala";

    console.log($scope.$parent.displayText);
    $scope.$parent.displayText = "Hello $parent";
});

Application.service("service1", function() {
    this.displayServiceFn = function() {
        console.log('in service');
    }
});

Application.factory("factory1", function() {
    var factoryObj = {};
    factoryObj.displayFactoryFn = function() {
        console.log('in factory');
    }
    return factoryObj;
})

Application.constant('MY_CONSTANT1', 'The Constant Text Value');

Application.directive('tutDirective', function() {
    return {
        template: 'Hello! Myself Custom Directive'
    };
});

// var app = angular.module("angularapp", ["ngAnimate"]);
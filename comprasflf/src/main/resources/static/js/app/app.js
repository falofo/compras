var app = angular.module('ComprasApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:9000/compras',
    ORDER_SERVICE_API : 'http://localhost:9000/compras/api/order',
    CUSTOMER_SERVICE_API : 'http://localhost:9000/compras/api/customer'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
               url: '/',
               templateUrl: 'partials/list',
               controller:'OrderController',
               controllerAs:'ctrl',
               resolve: {
                   customers: function ($q, CustomerService) {
                       console.log('Cargar todos los clientes');
                       var deferred = $q.defer();
                       CustomerService.loadAllCustomers().then(deferred.resolve, deferred.resolve);
                       return deferred.promise;
                   }
               }
            });
        $urlRouterProvider.otherwise('/');
    }]);


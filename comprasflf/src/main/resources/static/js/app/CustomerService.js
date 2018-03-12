'use strict';

angular.module('ComprasApp').factory('CustomerService',
    ['$localStorage', '$http', '$q', 'urls',
    function ($localStorage, $http, $q, urls) {

        var factory = {
            getAllCustomers: getAllCustomers,
            loadAllCustomers: loadAllCustomers
        };

        return factory;

        function loadAllCustomers() {
            console.log('Obteniendo clientes');
            var deferred = $q.defer();
            $http.get(urls.CUSTOMER_SERVICE_API)
                .then(
                    function (response) {
                        console.log('Clientes obtenidos satisfactoriamente');
                        $localStorage.customers = response.data;
                        deferred.resolve(response);
                    },
                    function (errResponse) {
                        console.error('Error cargando clientes');
                        deferred.reject(errResponse);
                    }
                );
            return deferred.promise;
        }

        function getAllCustomers(){
            return $localStorage.customers;
        }

    }
]);
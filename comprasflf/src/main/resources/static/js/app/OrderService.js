'use strict';

angular.module('ComprasApp').factory('OrderService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                getOrderByCustomerId: getOrderByCustomerId
            };

            return factory;

            function getOrderByCustomerId(id) {
                console.log('Obteniendo ordenes del cliente' + id);
                var deferred = $q.defer();
                $http.get(urls.ORDER_SERVICE_API+'/' +id)
                    .then(
                        function (response) {
                            console.log('Ordenes obtenidas satisfactoriamente');
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error obteniendo ordenes');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);
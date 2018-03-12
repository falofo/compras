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
                var endDate = new Date();
                endDate.setDate(endDate.getDate() + 1);
                var startDate = new Date();
                startDate.setMonth(startDate.getMonth() - 1);
                $http.get(urls.ORDER_SERVICE_API+'/' +id +'/' + yyyymmdd(startDate)+"/"+yyyymmdd(endDate))
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


            function yyyymmdd(date) {
              var mm = date.getMonth() + 1; // getMonth() is zero-based
              var dd = date.getDate();

              return [date.getFullYear(),
                      (mm>9 ? '' : '0') + mm,
                      (dd>9 ? '' : '0') + dd
                     ].join('');
            };

        }
    ]);
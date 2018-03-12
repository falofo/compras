'use strict';

angular.module('ComprasApp').controller('OrderController',
    ['OrderService','CustomerService', '$scope',  function( OrderService, CustomerService, $scope) {

        var self = this;
        self.customer = {};
        self.customers=[];
        self.orders=[];

        self.updateOrderList = updateOrderList;
        self.getAllCustomers = getAllCustomers;

        self.successMessage = '';
        self.errorMessage = '';

        function getAllCustomers(){
            return CustomerService.getAllCustomers();
        }

        function updateOrderList() {
            console.log('Consultando órdenes del cliente' + self.customer.id);
            OrderService.getOrderByCustomerId(self.customer.id)
                .then(
                    function (response) {
                        console.log('Consulta realizada satisfactoriamente');
                        self.orders=formatOrders(response.data);
                        self.errorMessage ='';
                    },
                    function (errResponse) {
                        console.error('Error consultando ordenes');
                        self.errorMessage = 'Error Consultando órdenes: no se encontraron órdenes para el cliente seleccionado';
                        self.successMessage='';
                        self.orders=[];
                    }
                );
        }

        function formatOrders(data){
            var ordersF = [];
            for(var i in data)
            {
                ordersF.push({
                    "creationDate"   : data[i].creationDate,
                    "orderId"       : data[i].orderId,
                    "total"         : formatTotal(data[i].detalle),
                    "deliveryAddress"   : data[i].deliveryAddress,
                    "products"      : formatProducts(data[i].detalle)
                });
            }
            return ordersF;
        }

        function formatTotal(data){
            var total = 0;
            for(var i in data)
            {
                total += data[i].product.price * data[i].quantity;
            }
            return total;
        }

        function formatProducts(data){
            var products = "";
            for(var i in data)
            {
                products += data[i].quantity + " x " + data[i].product.name + "\n";
            }
            return products;
        }
    }

]);
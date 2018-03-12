<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Clientes </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="cname">Clientes</label>
                            <div class="col-md-7">
                                <select ng-change="ctrl.updateOrderList()" ng-model="ctrl.customer.id" id="cname" name="cname" class="form-control input-sm" required place-holder="Seleccione un cliente">
                                    <option ng-repeat="customer in ctrl.getAllCustomers()" value="{{customer.customerId}}">{{customer.name}}</option>
                                </select>
                            </div>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Lista de ordenes </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>Creation Date</th>
		                <th>Order ID</th>
		                <th>Total $</th>
		                <th>Delivery Address</th>
		                <th>Products</th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="order in ctrl.orders">
		                <td>{{order.creationDate | date:'dd-MM-yyyy'}}</td>
		                <td>{{order.orderId}}</td>
		                <td>$ {{order.total.toFixed(2)}}</td>
		                <td>{{order.deliveryAddress}}</td>
		                <td>{{order.products}}</td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>
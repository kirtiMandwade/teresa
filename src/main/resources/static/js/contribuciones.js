
var app = angular.module('myapp', [ 'ui.bootstrap' ]);
app.config(['$compileProvider', function ($compileProvider) {
    $compileProvider.aHrefSanitizationWhitelist(/^\s*(|blob|):/);
}]);
app
		.controller(
				'UserController',
				[
						'$scope','$window',	
						'$timeout',
						'$http',
						'$compile',
						'$filter',
						'$sce',
						function($scope,$window, $timeout, $http, $compile,$filter,
								$sce) {
							$scope.número_de_pedimento=0;
							$scope.gensuccess = false;
							$scope.pedimento = [];
							$scope.one = true;
							$scope.loaded = false;
							$scope.two = true;
							$scope.valor = false;
							$scope.deppedimento = [];
							$scope.formdata28 = {};
							$scope.formdata36 = {};
							$scope.showContribucion=true;
							$scope.user = "User!";
							$scope.tabDisabled = true;
							$scope.dependencyData = [ {} ];
							$scope.viewby = 10;
							$scope.totalItems = 0;
							$scope.currentPage = 4;
							$scope.itemsPerPage = $scope.viewby;
							$scope.maxSize = 5; // Number of pager buttons to
												// show

// $http
// .get("/user/getNumero")
// .then(
// function(response) {
// console.log("numero",
// response);
// $scope.número_de_pedimento = response.data;
//										
//
// },
// function(response) { // error
// console
// .log("Error: "
// + response.status
// + " : "
// + response.data);
// });

							$scope.download=function(res){
								
								 var data = res.divData,
							        blob = new Blob([data], { type: 'text/plain' }),
							        url = $window.URL || $window.webkitURL;
							    $scope.fileUrl = url.createObjectURL(blob);
							    $scope.filename=res.filename;
							}
							$scope.map={
									"formdata28":$scope.formdata28,
									"formdata11":$scope.formdata11,
									"formdata23":$scope.formdata23,
									"formdata30":$scope.formdata30,
									"formdata21":$scope.formdata21,
									"formdata37":$scope.formdata37,
									"formdata25":$scope.formdata25
									
							};
							
							$scope.view={
									'one':$scope.one,
									'two':$scope.two,
									'valor':$scope.valor,
									'showContribucion':$scope.showContribucion,
									'permisos':$scope.permisos,
									'identificadores':$scope.identificadores,
									'nivelpartida':$scope.nivelpartida,

									'obnivelpartida':$scope.obnivelpartida
									
							};
						$scope.tipoPedimento = [ 'NA', 'Pedimento  Normal',
									'Desistimiento o Eliminación',
									'De la Industria Automotriz',
									'Pedimento Complementario',
									'Previo de Consolidado',
									'Global Complementario', 'Tránsitos',
									'Despacho Anticipado', 'Rectificaciones',
									'Confirmación de Pago'

							];

							$scope.getNameFor = function(id) {
								// var user =
								// $scope.tipoPedimento.filter(function(item) {
								// return item.id === id })[0];

								return $scope.tipoPedimento[id];
							}

							$scope.setPage = function(pageNo) {
								$scope.currentPage = pageNo;
							};

							$scope.pageChanged = function() {
								console.log('Page changed to: '
										+ $scope.currentPage);
							};

							$scope.setItemsPerPage = function(num) {
								$scope.itemsPerPage = num;
								$scope.currentPage = 1; // reset to first page
							}

							$scope.lock = function(itemid) {
								console.log("lock data"
										+ JSON.stringify(itemid));
								$scope.formDatas.push(itemid);

							};

							$scope.addPedimento = function() {
								console.log(" in showdiv function");
								$scope.one = false;
								$scope.two = true;
							};
							
							$scope.show = function(name,list,code,flag,clear) {
								console.log(" in showdiv function");
								
								
								if(clear=='true'){
								$scope[name]={};
								$scope[name].clave_del_Tipo_de_Registro=code;
								$scope[name].número_de_pedimento=$scope.número_de_pedimento;

							
								}
								
								  $http({
										url : '/user/getContriData',
										method : 'GET',
								params : {
									id:$scope.número_de_pedimento
								},
										headers : {
											"Content-Type" : "application/json"
										}

									}).success(function(response) {

										console.log("pedimento data ",
												response);
										$scope[list] = response;
										$scope.totalItems = $scope[list].length;
										$scope.loaded = true;
									}).error(function(error) {
										console
										.log("Error: "
												+ response.status
												+ " : "
												+ response.data);									});
													

							};
							
							
							
							$scope.edit = function(data,formname,flag) {
								
// $scope.one = false;
// $scope.two = true;
								$scope[formname]=data;

							};
							
							$scope.toggle=function(flag){
						        angular.forEach($scope.view, function (value, key) {
						        	if(flag==key){
						        		$scope[key]=true
						        	}else{
						        		$scope[key]=false;

						        	}
						        	
						        })

							}
							
							
							
							$scope.delete = function(data,list) {
								console.log(" in showdiv function"+data);
								
								
								 var index = $scope[list].indexOf(data);
								 $scope[list].splice(index, 1);  
								  var json = angular.toJson(data );

								  $http({
										url : '/user/deleteData',
										method : 'DELETE',
										data : json,
								params : {
									managerid : 1
								},
										headers : {
											"Content-Type" : "application/json"
										}

									}).success(function(response) {

										
									}).error(function(error) {
										$scope.error = error;
									});


															};
															
															$scope.deleteDepen = function(data) {
																console.log(" in showdiv function"+data);
																
																
																 var index = $scope.deppedimento.indexOf(data);
																  $scope.deppedimento.splice(index, 1);  
																  
																  $http({
																		url : '/user/delete/generals',
																		method : 'DELETE',
																		data : data,
																		headers : {
																			"Content-Type" : "application/json"
																		}

																	}).success(function(response) {

																		$scope.response = "M File Generated";
																		$scope.gensuccess = true;
																		$scope.download(response);
																	}).error(function(error) {
																		$scope.error = error;
																	});


																							};
							$scope.return = function() {
								console.log(" in showdiv function");
								$scope.one = true;
								$scope.two = false;
								$scope.formdata28 = {};

								$http
										.get("/user/getPartidasData")
										.then(
												function(response) {
													console.log("pedimento data ",
															response);
													$scope.pedimento = response.data;
													$scope.totalItems = $scope.pedimento.length;
													$scope.loaded = true;

												},
												function(response) { // error
													console
															.log("Error: "
																	+ response.status
																	+ " : "
																	+ response.data);
												});


							};
							$scope.dependentReturn = function() {
								console.log(" in showdiv function");
					};

							
							
							$http
									.get("/user/getContriData")
									.then(
											function(response) {
												console.log("pedimento data ",
														response);
												$scope.pedimento = response.data;
												$scope.totalItems = $scope.pedimento.length;
												$scope.loaded = true;

											},
											function(response) { // error
												console
														.log("Error: "
																+ response.status
																+ " : "
																+ response.data);
											});

							
							
							$scope.save = function(itemid, formid, managerid,formname,list,code,flag,clear) {
								$scope.depObj = {};
								
								
							      
								$scope.número_de_pedimento=itemid.númerodepedimento;
								
									 var json = angular.toJson(itemid );

													$http(
															{
																url : '/user/saveContri',
																method : 'POST',
																data : json,
																
																headers : {
																	"Content-Type" : "application/json"
																}

															})
															.success(
																	function(
																			response) {
																		$scope.depObj.key = itemid.clave_del_Tipo_de_Registro;
																		$scope.depObj.value = response.id;
																		$scope.dependencyData
																				.push($scope.depObj);
																		console
																				.log($scope.dependencyData);
																		$scope.show(formname,list,code,flag,clear);
																		
																																			})
															.error(
																	function(
																			error) {
																		$scope.error = error;
																	});

												};
											

						


							
						} ]);

app.directive("limitTo", [ function() {
	return {
		restrict : "A",
		link : function(scope, elem, attrs) {
			var limit = parseInt(attrs.limitTo);
			angular.element(elem).on("keypress", function(e) {
				if (this.value.length == limit)
					e.preventDefault();
			});
		}
	}
} ]);

app.directive('allowDecimalNumbers', function() {
	return {
		restrict : 'A',
		link : function(scope, elm, attrs, ctrl) {
			elm
					.on('keydown',
							function(event) {
								var $input = $(this);
								var value = $input.val();
								value = value.replace(/[^0-9\.]/g, '')
								var findsDot = new RegExp(/\./g)
								var containsDot = value.match(findsDot)
								if (containsDot != null
										&& ([ 46, 110, 190 ]
												.indexOf(event.which) > -1)) {
									event.preventDefault();
									return false;
								}
								$input.val(value);
								if (event.which == 64 || event.which == 16) {
									// numbers
									return false;
								}
								if ([ 8, 13, 27, 37, 38, 39, 40, 110 ]
										.indexOf(event.which) > -1) {
									// backspace, enter, escape, arrows
									return true;
								} else if (event.which >= 48
										&& event.which <= 57) {
									// numbers
									return true;
								} else if (event.which >= 96
										&& event.which <= 105) {
									// numpad number
									return true;
								} else if ([ 46, 110, 190 ]
										.indexOf(event.which) > -1) {
									// dot and numpad dot
									return true;
								} else {
									event.preventDefault();
									return false;
								}
							});
		}
	}
});

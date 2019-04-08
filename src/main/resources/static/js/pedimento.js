
var app = angular.module('myapp', [ 'ui.bootstrap' ]);
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
							$scope.two = false;
							$scope.transporte = false;
							$scope.deppedimento = [];
							$scope.formdata1 = {};
							$scope.formdata36 = {};
							$scope.user = "User!";
							$scope.tabDisabled = true;
							$scope.dependencyData = [ {} ];
							$scope.viewby = 10;
							$scope.totalItems = 0;
							$scope.currentPage = 4;
							$scope.itemsPerPage = $scope.viewby;
							$scope.maxSize = 5; // Number of pager buttons to
												// show

							
							$scope.download=function(res){
								
								 var data = res.divData,
							        blob = new Blob([data], { type: 'text/plain' }),
							        url = $window.URL || $window.webkitURL;
							    $scope.fileUrl = url.createObjectURL(blob);
							    $scope.filename=res.filename;
							}
							$scope.map={
									"formdata1":$scope.formdata1,
									"formdata36":$scope.formdata36,
									"formdata36":$scope.formdata19,
									"formdata36":$scope.formdata4,
									"formdata36":$scope.formdata15,
									"formdata36":$scope.formdata16,
									"formdata36":$scope.formdata20,
									"formdata36":$scope.formdata7,
									"formdata36":$scope.formdata24,
									"formdata36":$scope.formdata8,
									"formdata36":$scope.formdata3,
									"formdata36":$scope.formdata14,
									"formdata36":$scope.formdata2,
									"formdata36":$scope.formdata9
									
									
							};
							
							$scope.view={
									'one':$scope.one,
									'two':$scope.two,
									'transporte':$scope.transporte,

									'guias':$scope.guias,
									'contenedores':$scope.contenedores,
									'facturas':$scope.facturas,
									'fechas':$scope.fechas,
									'identificadores':$scope.identificadores,
									'cuentasaduaneras':$scope.cuentasaduaneras,
									'observaciones':$scope.observaciones,
									'descargos':$scope.descargos,
									'compensaciones':$scope.compensaciones,
									'documentosPagoVirtuales':$scope.documentosPagoVirtuales,
									
									'candados':$scope.candados,
									'destinatario':$scope.destinatario
									
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
								
								
								$scope.toggle(flag);
								if(clear=='true'){
								$scope[name]={};
								$scope[name].clave_del_Tipo_de_Registro=code;
								$scope[name].número_de_pedimento = $scope.número_de_pedimento;
								$scope[name].número_de_Pedimento = $scope.número_de_pedimento;
								$scope[name].número_Pedimento = $scope.número_de_pedimento;
								$scope[name].número_pedimento = $scope[name].número_de_pedimento;
								}
								  $http({
										url : '/user/getData',
										method : 'GET',
								params : {
									code : code,
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
								
								console.log(" in showdiv function"+$scope.map[formname].clave_del_Tipo_de_Registro);
//								$scope.one = false;
//								$scope.two = true;
								$scope[formname]=data;
								$scope.toggle(flag);
								
//						
//								  $http({
//										url : '/user/updateNumero',
//										method : 'PUT',
//								params : {
//									
//									numero:data.número_de_pedimento
//								},
//										headers : {
//											"Content-Type" : "application/json"
//										}
//
//									}).success(function(response) {
//										
//									}).error(function(error) {
//										console
//										.log("Error: "
//												+ response.status
//												+ " : "
//												+ response.data);									});
//
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
								$scope.formdata1 = {};
							};
							$scope.dependentReturn = function() {
								console.log(" in showdiv function");
								console.log(" in showdiv function");
								$scope.toggle('two');		
							};

							
							
							$http
									.get("/user/getGeneralsData")
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
								
								if(code=='501'){
									$scope.número_de_pedimento=itemid.número_de_pedimento;
								}
								
								$http({
									method : "GET",
									url : "/user/getParentFormid/",
									params : {
										formid : formid,
										managerid : managerid
									}
								})
										.then(
												function mySuccess(response) {
													$scope.dependencyData
															.map(function(value) {
																if (value.key == response.data) {
																	itemid.clave_formulario_principal = value.value;
																}
															});
													console
															.log(itemid.clave_formulario_principal);
													  var json = angular.toJson(itemid );

													$http(
															{
																url : '/user/save',
																dataType : 'string',
																method : 'POST',
																data : json,
																params : {
																	formid : formid,
																	managerid : managerid
																},
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

												},
												function myError(response) {
													console.log("error ",
															response);
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

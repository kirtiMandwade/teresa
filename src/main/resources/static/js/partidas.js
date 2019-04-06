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
							
							$scope.gensuccess = false;
							$scope.pedimento = [];
							$scope.one = true;
							$scope.loaded = false;
							$scope.two = false;
							$scope.selectedPedimento = [];
							$scope.arrMenu = [];
							$scope.formdata = {};
							$scope.currentForm = {};
							$scope.user = "User!";
							$scope.formDatas = [];
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

							$scope.showDiv = function() {
								console.log(" in showdiv function");
								$scope.formParentdiv = true;
								$scope.tabDiv = false;

							};

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

							$scope.editTableData = function(id, formCode,
									itemid) {
								console.log("formData ", id);
								var modelName = 'formdata' + id;
								$scope[modelName] = {};
								console.log("$scope.formData ",
										$scope[modelName]);

								$http({
									method : "GET",
									url : "/user/getRow/",
									params : {
										code : formCode,
										id : itemid
									}
								})
										.then(
												function mySuccess(response) {

													console.log("reponse ",
															response);
													$scope[modelName] = response.data[0];
													console
															.log(
																	"success $scope.rowData",
																	$scope[modelName]);

												},
												function myError(response) {
													console.log("error ",
															response);
												});

							};

							$scope.deleteTableData = function(formCode, itemid) {

								$http({
									method : "GET",
									url : "/user/deleteRow/",
									params : {
										code : formCode,
										id : itemid
									}
								}).then(function mySuccess(response) {

									console.log("reponse ", response);

								}, function myError(response) {
									console.log("error ", response);
								});

							};
							$scope.getPedimentoTableData = function(iname) {
								$scope.dependencyData = [ {} ];
								document.getElementById("peditableData").innerHTML = "";

								$scope.one = false;
								$scope.two = true;
								$scope.success = false;
								$http
										.get("/user/getPedimentoTable/" + iname)
										.then(
												function(response) {
													console.log(response);
													$scope.arrForms = response.data.divData;
													var fulldiv = angular
															.element($scope.arrForms);

													var compiledDiv = $compile(
															fulldiv)($scope);

													var target = document
															.getElementById('peditableData');
													angular
															.element(target)
															.append(compiledDiv);

												})

							}

							$scope.showMessage = function(iname) {
								document.getElementById("userform").innerHTML = "";
								$scope.one = true;
								$scope.two = false;
								$scope.success = false;
								$http
										.get("/user/getForms/" + iname)
										.then(
												function(response) {
													console.log(response);
													$scope.arrForms = response.data.divData;
													var fulldiv = angular
															.element($scope.arrForms);

													var compiledDiv = $compile(
															fulldiv)($scope);

													var target = document
															.getElementById('userform');
													angular
															.element(target)
															.append(compiledDiv);

												})

							};

							$scope.getSelected = function() {
								var ar = $scope.pedimento
										.filter(function(value) {
											if (value.checked == 1) {
												return true;
											} else {
												return false;
											}
										});

								console.log("get selected ", ar);
								return ar;
							};

							$scope.generateMfile = function() {
								var arrgen = $scope.getSelected();
								// $scope.arrgen.concat({"momento":$scope.tabledata});
								console.log("mfile data ", arrgen);

								$http({
									url : '/user/generateMfile',
									dataType : 'string',
									method : 'POST',
									data : JSON.stringify(arrgen),
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

							$scope.showOne = function(iname) {
								$scope.success = false;
								console.log("showOne");
								$scope.one = true;
								$scope.formdata = {};
								$scope.currentForm = {};
								document.getElementById("userform").innerHTML = "";

								$scope.currentForm = $filter('filter')(
										$scope.arrMenu, {
											formid : "" + iname
										})[0];

								angular
										.forEach(
												$scope.currentForm.fields,
												function(item, index) {
													$scope.formdata[item.name
															.split(" ")
															.join("")] = item.defaultValue;

												});

								console
										.log("formfields-----"
												+ $scope.formdata)
								angular
										.forEach(
												$scope.currentForm.fields,
												function(item, index) {
													var newLable = angular
															.element('<div class="col-sm-2" ></div><label class="col-sm-2 control-label" for="keyofrecord">'
																	+ item.name
																	+ '</label>');

													if (item.type.toLowerCase() == 'select') {

														var newEle = angular
																.element('<div class="col-sm-8"><select id="second-choice" ng-model="formdata.'
																		+ item.name
																				.split(
																						" ")
																				.join(
																						"")
																		+ '" required="required" class="form-control" ></select>');
														var target = document
																.getElementById('#userform');
														angular
																.element(target)
																.append(
																		newLable);
														angular.element(target)
																.append(newEle);

														$http
																.get(
																		"/user/getAppendiceRel/"
																				+ item.appendiceData.name)
																.then(
																		function(
																				response) {
																			console
																					.log(response);
																			$scope.arrAppendice = response.data;
																			console
																					.log($scope.arrAppendice);

																			angular
																					.forEach(
																							$scope.arrAppendice,
																							function(
																									aitem,
																									index) {
																								console
																										.log("***"
																												+ item)
																								console
																										.log(aitem[item.appendiceData.textCol]);
																								var firstDynamicVal = aitem[item.appendiceData.textCol];

																								var newEle = angular
																										.element('<option value="'
																												+ aitem[item.appendiceData.valueCol[0]]
																												+ aitem[item.appendiceData.valueCol[1]]
																												+ '">'
																												+ firstDynamicVal
																												+ '</option>');

																								var target = document
																										.getElementById('second-choice');
																								angular
																										.element(
																												target)
																										.append(
																												newEle);
																							})
																		});

													} else if (item.type
															.toLowerCase() == 'number') {
														var newEle = angular
																.element('<div class="col-sm-8"><input  valid-number ng-model="formdata.'
																		+ item.name
																				.split(
																						" ")
																				.join(
																						"")
																		+ '" ng-disabled='
																		+ item.isDisabled
																		+ ' type="'
																		+ item.type
																		+ '" id="'
																		+ item.name
																		+ '" limit-to="'
																		+ item.length
																		+ '" name="'
																		+ item.name
																		+ '"  maxlength="'
																		+ item.length
																		+ '"  value="'
																		+ item.defaultValue
																		+ '" class='
																		+ '"form-control"'
																		+ '></input></div>');

													} else
														var newEle = angular
																.element('<div class="col-sm-8"><input   ng-model="formdata.'
																		+ item.name
																				.split(
																						" ")
																				.join(
																						"")
																		+ '" ng-disabled='
																		+ item.isDisabled
																		+ ' type="'
																		+ item.type
																		+ '" id="'
																		+ item.name
																		+ '" name="'
																		+ item.name
																		+ '"  maxlength="'
																		+ item.length
																		+ '" value="'
																		+ item.defaultValue
																		+ '" class='
																		+ '"form-control"'
																		+ '></input></div>');

													var compiledVar = $compile(
															newEle)($scope);

													var target = document
															.getElementById('userform');

													angular.element(target)
															.append(newLable);
													angular
															.element(target)
															.append(compiledVar);

													// $scope.formdata.KeyofRecord=501;

												})

							}

							$http
									.get("/user/getMenu")
									.then(
											function(response) {
												console.log(response);
												$scope.arrMenu = response.data;
												console.log("MENU DATA ",
														$scope.arrMenu);

												angular
														.forEach(
																$scope.arrMenu,
																function(item,
																		index) {
																	var newEle = angular
																			.element('<li class="mt"><a href="#"ng-click="getPedimentoTableData('
																					+ index
																					+ ')">'
																					+ '<span>'
																					+ item.name
																					+ '</span>'
																					+ '</a></li>');
																	var compiledVar = $compile(
																			newEle)
																			(
																					$scope);

																	var target = document
																			.getElementById('nav-accordion');
																	angular
																			.element(
																					target)
																			.append(
																					compiledVar);
																})
											});

							/*
							 * $scope.save = function() {
							 *  // console.log(JSON.stringify($scope.formData));
							 * 
							 * $http({ url : '/user/save', dataType : 'string',
							 * method : 'POST', data :
							 * JSON.stringify($scope.formDatas), headers : {
							 * "Content-Type" : "application/json" }
							 *  }) .success( function(response) { $scope.one =
							 * false; $scope.response = "Data Saved
							 * Successfully";
							 * 
							 * 
							 * console.log("data save "+$scope.formdata);
							 * $timeout(window.location.reload(), 400000);
							 * //window.location.reload(); $scope.success =
							 * true;
							 * 
							 * }).error(function(error) { $scope.error = error;
							 * });
							 *  };
							 */

							/*
							 * $scope.save = function(itemid,event) {
							 * //$scope.disable=true; console.log("data save
							 * "+JSON.stringify(itemid)); $http({ url :
							 * '/user/save', dataType : 'string', method :
							 * 'POST', data : JSON.stringify(itemid), headers : {
							 * "Content-Type" : "application/json" }
							 *  }) .success( function(response) { //$scope.one =
							 * false; $scope.response = "Data Saved
							 * Successfully";
							 * 
							 * event.stopPropagation(); //console.log("data save
							 * "+$scope.formdata); //
							 * $timeout(window.location.reload(), 400000);
							 * //window.location.reload(); $scope.success =
							 * true;
							 * 
							 * }).error(function(error) { $scope.error = error;
							 * });
							 * 
							 *  };
							 */

							$scope.save = function(itemid, formid, managerid) {
								$scope.depObj = {};

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
													$http(
															{
																url : '/user/save',
																dataType : 'string',
																method : 'POST',
																data : JSON
																		.stringify(itemid),
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
																		// $scope.one
																		// =
																		// false;
																		// $scope.response
																		// =
																		// "Data
																		// Saved
																		// Successfully";
																		//	

																		// console.log("data
																		// save
																		// "+$scope.formdata);
																		// $timeout(window.location.reload(),
																		// 400000);
																		// window.location.reload();
																		// $scope.success
																		// =
																		// true;

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

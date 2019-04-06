var app = angular.module('myapp', []);

app
		.controller(
				'UserController',
				[
						'$scope',

						'$http',
						'$compile',
						'$filter','$sce',
						function($scope, $http, $compile, $filter,$sce) {
							console.log("scriptloaded");

							$scope.one = true;
							$scope.arrMenu = [];
							$scope.formdata={};
							$scope.currentForm={};
							$scope.user="User!";
							$scope.formDatas=[];
							
							$scope.lock = function(itemid) {

								$scope.formDatas.push(itemid);
								
								

							};

							
							
							$scope.showMessage = function(iname) {
								document.getElementById("userform").innerHTML = "";

								$scope.one = true;

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
																		.element(
																				target)
																		.append(
																				compiledDiv);
															
															})
											
								
								
							};
							
							$scope.showOne = function(iname) {
								$scope.success = false;
								console.log("showOne");
								$scope.one = true;
								$scope.formdata={};
								$scope.currentForm={};
								document.getElementById("userform").innerHTML = "";

								$scope.currentForm = $filter('filter')(
										$scope.arrMenu, {
											formid : "" +iname
										})[0];
								
								angular
								.forEach(
										$scope.currentForm.fields,
										function(item, index) {
											 $scope.formdata[item.name.split(" ").join("")]=item.defaultValue;
											
										});
								
								console.log("formfields-----"+$scope.formdata)
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
																.element('<div class="col-sm-8"><select id="second-choice" ng-model="formdata.'+item.name.split(" ").join("")+'" required="required" class="form-control" ></select>');
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
																		"/user/getAppendiceRel/"+item.appendiceData.name)
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
																												console.log(aitem[item.appendiceData.textCol]);
																								var firstDynamicVal = aitem[item.appendiceData.textCol];

																								var newEle = angular
																										.element('<option value="'
																												+ aitem[item.appendiceData.valueCol[0]]+aitem[item.appendiceData.valueCol[1]]
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

													} else if (item.type.toLowerCase() == 'number'){
														var newEle = angular
																.element('<div class="col-sm-8"><input  valid-number ng-model="formdata.'+item.name.split(" ").join("")+'" ng-disabled=' 
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
																		+'></input></div>');
														
														
														
														
													}
													else
														var newEle = angular
																.element('<div class="col-sm-8"><input   ng-model="formdata.'+item.name.split(" ").join("")+'" ng-disabled='
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
																		+'></input></div>');
													
													var compiledVar = $compile(
															newEle)($scope);

													var target = document
															.getElementById('userform');

													angular.element(target)
															.append(newLable);
													angular
															.element(target)
															.append(compiledVar);

													
//													$scope.formdata.KeyofRecord=501;
											
												})
												
															
							}

							$http
									.get("/user/getMenu")
									.then(
											function(response) {
												console.log(response);
												$scope.arrMenu = response.data;
												console.log($scope.arrMenu);

												angular
														.forEach(
																$scope.arrMenu,
																function(item,
																		index) {
																	var newEle = angular
																			.element('<li class="mt"><a href="#"ng-click="showMessage('
																					+ index
																					+ ')">'
																					+'<span>' +item.name
																					+'</span>'
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

							
							$scope.save = function() {

								//										 	       console.log(JSON.stringify($scope.formData));

								$http({
									url : '/user/save',
									dataType : 'string',
									method : 'POST',
									data : JSON.stringify($scope.formDatas),
									headers : {
										"Content-Type" : "application/json"
									}

								})
										.success(
												function(response) {
													$scope.one = false;
													$scope.response = "Data Saved Successfully";

													$scope.success = true;

												}).error(function(error) {
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

app.directive('allowDecimalNumbers', function () {  
	return {  
        restrict: 'A',  
        link: function (scope, elm, attrs, ctrl) {  
            elm.on('keydown', function (event) {  
                var $input = $(this);  
                var value = $input.val();  
                value = value.replace(/[^0-9\.]/g, '')  
                var findsDot = new RegExp(/\./g)  
                var containsDot = value.match(findsDot)  
                if (containsDot != null && ([46, 110, 190].indexOf(event.which) > -1)) {  
                    event.preventDefault();  
                    return false;  
                }  
                $input.val(value);  
                if (event.which == 64 || event.which == 16) {  
                    // numbers  
                    return false;  
                } if ([8, 13, 27, 37, 38, 39, 40, 110].indexOf(event.which) > -1) {  
                    // backspace, enter, escape, arrows  
                    return true;  
                } else if (event.which >= 48 && event.which <= 57) {  
                    // numbers  
                    return true;  
                } else if (event.which >= 96 && event.which <= 105) {  
                    // numpad number  
                    return true;  
                } else if ([46, 110, 190].indexOf(event.which) > -1) {  
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


/*app.directive('validNumber', function() {
  return {
    require: '?ngModel',
    link: function(scope, element, attrs, ngModelCtrl) {
      if(!ngModelCtrl) {
        return; 
      }

      ngModelCtrl.$parsers.push(function(val) {
        if (angular.isUndefined(val)) {
            var val = '';
        }
        
        var clean = val.replace(/[^-0-9\.]/g, '');
        var negativeCheck = clean.split('-');
		var decimalCheck = clean.split('.');
        if(!angular.isUndefined(negativeCheck[1])) {
            negativeCheck[1] = negativeCheck[1].slice(0, negativeCheck[1].length);
            clean =negativeCheck[0] + '-' + negativeCheck[1];
            if(negativeCheck[0].length > 0) {
            	clean =negativeCheck[0];
            }
            
        }
          
        if(!angular.isUndefined(decimalCheck[1])) {
            decimalCheck[1] = decimalCheck[1].slice(0,2);
            clean =decimalCheck[0] + '.' + decimalCheck[1];
        }

        if (val !== clean) {
          ngModelCtrl.$setViewValue(clean);
          ngModelCtrl.$render();
        }
        return clean;
      });

      element.bind('keypress', function(event) {
        if(event.keyCode === 32) {
          event.preventDefault();
        }
      });
    }
  };
});*/

//no space
//ng-keydown="$event.keyCode != 32 ? $event:$event.preventDefault()"
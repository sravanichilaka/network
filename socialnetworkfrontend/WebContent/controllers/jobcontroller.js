/**
 * JobCtrl
 */
app.controller('JobCtrl',function($scope,JobService,$location,$rootScope){
	$scope.addJob=function(job){
		$scope.isClicked=false
		JobService.addJob(job).then(
				function(response){
					alert('Job details inserted successfully')
					$location.path('/home')
				},function(response){
					//3 return statement for error in middleware
					$scope.error=response.data
					if($scope.error.errorCode==7){//not logged in
						$rootScope.error=response.data
						$location.path('/login')
					}
					
				})
	}
	
	function getActiveJobs(){//select * from job where active=true
		JobService.getActiveJobs().then(function(response){
			//response.data is Array of Active jobs[{... active=true},{...,active=true}] for success
			$scope.activeJobs=response.data
		},function(response){
			//response.data is ErrorClazz object
			$scope.error=response.data
			if(response.status==401)
			$location.path('/login')
		})
	}
	function getInActiveJobs(){
		JobService.getInActiveJobs().then(function(response){
			//response.data is array of inactive jobs
			$scope.inActiveJobs=response.data
		},function(response){
			$scope.error=response.data
			if(response.data.errorCode==7)
			 $location.path('/login')
		})
	}
	
	$scope.showJobDetails=function(id){
		$scope.id=id//for this job id, has to show more details 
		$scope.isClicked=!$scope.isClicked;
		//                          on click                    on click
		//false -> show more details -> true -> hide more details -> false -> show more details 
		
		//isClicked=false [show more details] -> isCliked=true -> hide more details
	}
	$scope.deactivateJobPosition=function(job){
		//change the value of the property active to false
		job.active=false //true to false
		JobService.updateActiveStatus(job).then(
				function(response){
					getActiveJobs()
				},
				function(response){
					$scope.error=response.data
					if(response.status==401)
						$location.path('/login')
				})
	}
	
	$scope.activateJobPosition=function(job){
		//change the value of the property active to false
		job.active=true//false to true
		JobService.updateActiveStatus(job).then(
				function(response){
					getInActiveJobs()//$scope.inActiveJobs=select * from job where active=false
				},
				function(response){
					$scope.error=response.data
					if(response.status==401)
						$location.path('/login')
				})
	}
	
	getActiveJobs()//function call
	
	if($rootScope.loggedInUser.role=='ADMIN')
      getInActiveJobs()
})

	
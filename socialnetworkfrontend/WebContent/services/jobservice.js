/**
 * Job Service
 */
app.factory('JobService',function($http){

	var jobService={}
	
	jobService.addJob=function(job){
		return $http.post("http://localhost:8090/socialnetworkmiddleware/addjob",job)
	}
	
	jobService.getActiveJobs=function(job){
		return $http.get("http://localhost:8090/socialnetworkmiddleware/activejobs")
	}
	
	jobService.getInActiveJobs=function(job){
		return $http.get("http://localhost:8090/socialnetworkmiddleware/inactivejobs")
	}
	
	jobService.updateActiveStatus=function(job){
		return $http.put("http://localhost:8090/socialnetworkmiddleware/updatejob",job)
	}
	return jobService;
	
})
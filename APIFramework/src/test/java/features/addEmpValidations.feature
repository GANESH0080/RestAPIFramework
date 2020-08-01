Feature: Validating ADD API 

Scenario Outline: Verify If ADD is being successfully added using AddEmpAPI 
	Given createEmp Payload with "<name>" "<salary>"
	When user call "AddEmp" with "POST" http request 	
	Then the API call is success with message success 
	And status in response body is success 
	And name in response body is Ganusalunkhe 
	When user calls "GetEmp" with "GET" http request 
	When user calling "DeleteEmp" with "DELETE" http request 
	
	
	Examples: 
	|name|salary|
	|Shlok|345464|
	|Shri|364|
	|OV|678574|
	|Ganesh|3757464|
	
   
node('linux')
enviroment{
	credentialsID = 'michalnagosa2c'
}
def customeImage = ''
stage('git'){
	git branch: 'master',
	   url:https://github.com/michalnagosa2/flask-http.git
}
